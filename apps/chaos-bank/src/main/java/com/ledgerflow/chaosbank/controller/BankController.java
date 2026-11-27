package com.ledgerflow.chaosbank.controller;

import com.ledgerflow.chaosbank.dto.AuthorizeRequest;
import com.ledgerflow.chaosbank.dto.BankResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/bank")
public class BankController {

    // Simple thread-safe in-memory store for transactions
    private final ConcurrentHashMap<String, BankResponse> transactionStore = new ConcurrentHashMap<>();

    @PostMapping("/authorize")
    public ResponseEntity<BankResponse> authorize(@RequestBody AuthorizeRequest request) {
        String bankRef = "bnk_" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);

        BankResponse response = new BankResponse(
                bankRef,
                "APPROVED",
                request.amountMinor(),
                request.currency() != null ? request.currency() : "INR",
                Instant.now()
        );

        transactionStore.put(bankRef, response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/capture")
    public ResponseEntity<BankResponse> capture(@RequestParam String bankRef) {
        BankResponse existing = transactionStore.get(bankRef);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        BankResponse captured = new BankResponse(
                existing.bankRef(),
                "CAPTURED",
                existing.amountMinor(),
                existing.currency(),
                Instant.now()
        );

        transactionStore.put(bankRef, captured);
        return ResponseEntity.ok(captured);
    }
}
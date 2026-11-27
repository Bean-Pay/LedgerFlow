package com.ledgerflow.chaosbank.dto;

import java.time.Instant;

public record BankResponse(
        String bankRef,
        String status,
        long amountMinor,
        String currency,
        Instant timestamp
) {}
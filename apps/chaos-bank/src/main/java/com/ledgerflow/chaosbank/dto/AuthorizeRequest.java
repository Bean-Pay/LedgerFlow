package com.ledgerflow.chaosbank.dto;

public record AuthorizeRequest(
        String idempotencyKey,
        String merchantId,
        long amountMinor,
        String currency
) {}
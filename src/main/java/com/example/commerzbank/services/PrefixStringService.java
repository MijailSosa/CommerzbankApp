package com.example.commerzbank.services;

import java.util.concurrent.CompletableFuture;

public interface PrefixStringService {
    CompletableFuture<String> getStringValue();
    void setStringValue(String stringValue);
}

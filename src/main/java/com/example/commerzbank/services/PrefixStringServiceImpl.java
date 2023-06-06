package com.example.commerzbank.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PrefixStringServiceImpl implements PrefixStringService {


    @Value("${string.value: value not set in properties}")
    private String stringValue;
    @Override
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
    @Override
    @Async
    public CompletableFuture<String> getStringValue() {
        return CompletableFuture.completedFuture(stringValue);
    }
}

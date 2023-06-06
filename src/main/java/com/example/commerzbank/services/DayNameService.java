package com.example.commerzbank.services;

import java.util.concurrent.CompletableFuture;

public interface DayNameService {
    CompletableFuture<String> getDayName();

}

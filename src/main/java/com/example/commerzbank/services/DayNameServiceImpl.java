package com.example.commerzbank.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.CompletableFuture;

@Service
public class DayNameServiceImpl implements DayNameService {

    @Override
    @Async
    public CompletableFuture<String> getDayName() {
        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        Calendar calendar = Calendar.getInstance();
        return CompletableFuture.completedFuture(dateFormat.format(calendar.getTime()));
    }
}

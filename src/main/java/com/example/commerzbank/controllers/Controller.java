package com.example.commerzbank.controllers;

import com.example.commerzbank.services.DayNameService;
import com.example.commerzbank.services.PrefixStringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class Controller {

    private final DayNameService dayNameService;
    private final PrefixStringService prefixStringService;

    public Controller(DayNameService dayNameService, PrefixStringService services) {
        this.dayNameService = dayNameService;
        this.prefixStringService = services;
    }

    @RequestMapping(value = "/date")
    public String getDate() {
        CompletableFuture<String> prefixString = prefixStringService.getStringValue();
        CompletableFuture<String> dayName = dayNameService.getDayName();
         try {
             return prefixString.get() + " " + dayName.get();
         } catch (ExecutionException | InterruptedException e) {
             throw new RuntimeException(e);
         }

    }

    @RequestMapping(value = "/update/{string}")
    public ResponseEntity<Object> updateString(@PathVariable("string") String string) {
        prefixStringService.setStringValue(string);
        return new ResponseEntity<>("String value updated successfully", HttpStatus.OK);
    }

}
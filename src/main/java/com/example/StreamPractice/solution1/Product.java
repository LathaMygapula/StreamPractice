package com.example.StreamPractice.solution1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;
    private String currency;
    private String eventTime; // ISO date string
    private String eventType;
}


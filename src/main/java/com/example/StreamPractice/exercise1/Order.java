package com.example.StreamPractice.exercise1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String orderId;
    private String productId;
    private String userId;
    private double orderAmount;
    private int quantity;
    private String paymentMode;
    private String orderStatus; // e.g. "PLACED", "CANCELLED"
    private String source; // e.g. "WEB", "MOBILE_APP", "POS"
    private String country;
    private String eventTime; // ISO date string
}

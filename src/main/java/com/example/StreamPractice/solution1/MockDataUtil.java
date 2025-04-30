package com.example.StreamPractice.solution1;

import java.util.ArrayList;
import java.util.List;

class MockDataUtil {

    public static List<Product> getMockProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("P12345", "Wireless Mouse", "Electronics", 1499.00, "INR", "2025-04-22T10:05:00Z",
                "PRICE_UPDATE"));

        products.add(new Product("P67890", "Gaming Keyboard", "Electronics", 3499.00, "INR", "2025-04-22T09:55:00Z",
                "PRICE_UPDATE"));

        products.add(new Product("P11111", "Bluetooth Speaker", "Electronics", 1999.00, "INR", "2025-04-22T09:50:00Z",
                "PRICE_UPDATE"));

        products.add(new Product("P22222", "Fitness Tracker", "Wearables", 2999.00, "INR", "2025-04-22T10:00:00Z",
                "PRICE_UPDATE"));

        return products;
    }

    public static List<Order> getMockOrders() {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("O98765", "P12345", "U67890", 2998.00, 2, "UPI", "PLACED", "MOBILE_APP", "IN",
                "2025-04-22T10:06:12Z"));

        orders.add(new Order("O54321", "P12345", "U12345", 1499.00, 1, "CREDIT_CARD", "PLACED", "WEB", "IN",
                "2025-04-22T10:06:30Z"));

        orders.add(new Order("O22222", "P67890", "U33333", 3499.00, 1, "NET_BANKING", "PLACED", "WEB", "IN",
                "2025-04-22T10:07:12Z"));

        orders.add(new Order("O98765", "P12345", "U67890", 0.00, 0, "UPI", "CANCELLED", "MOBILE_APP", "IN",
                "2025-04-22T10:10:45Z"));

        orders.add(new Order("O45678", "P67890", "U11111", 3499.00, 1, "CASH", "PLACED", "POS", "IN",
                "2025-04-22T10:07:30Z"));

        orders.add(new Order("O45679", "P67890", "U11112", 3499.00, 1, "CASH", "PLACED", "POS", "IN",
                "2025-04-22T10:07:45Z"));

        orders.add(new Order("O45680", "P67890", "U11113", 3499.00, 1, "CASH", "PLACED", "POS", "IN",
                "2025-04-22T10:08:00Z"));

        orders.add(new Order("O99999", "P22222", "U98765", 2999.00, 1, "UPI", "PLACED", "WEB", "IN",
                "2025-04-22T09:59:00Z"));

        orders.add(new Order("O10001", "P11111", "U55555", 1999.00, 1, "CREDIT_CARD", "PLACED", "MOBILE_APP", "IN",
                "2025-04-22T10:09:00Z"));

        orders.add(new Order("O10001", "P11111", "U55555", 1999.00, 1, "CREDIT_CARD", "PLACED", "WEB", "IN",
                "2025-04-22T10:09:10Z"));

        return orders;
    }
}

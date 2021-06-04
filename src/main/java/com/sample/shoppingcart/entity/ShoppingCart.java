package com.sample.shoppingcart.entity;

import java.time.Instant;
import java.util.List;

public class ShoppingCart {
    private String countryCode;
    private String currency;
    private Instant created;
    private Instant updated;
    private List<Product> products;
}

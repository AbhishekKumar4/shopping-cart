package com.sample.shoppingcart.dto;

import com.sample.shoppingcart.entity.Product;

import java.time.Instant;
import java.util.List;

public class ShoppingCartDTO {
    private String countryCode;
    private String currency;
    private Instant created;
    private Instant updated;
    private List<Product> products;
}

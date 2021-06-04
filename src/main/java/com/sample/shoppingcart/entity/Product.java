package com.sample.shoppingcart.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Product {
    private UUID id;
    private String description;
    private String category;
    private BigDecimal price;
    private Instant created;
    private Instant updated;
}

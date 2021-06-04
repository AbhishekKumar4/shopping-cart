package com.sample.shoppingcart.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class ProductDTO {
    private UUID id;
    private String description;
    private String category;
    private BigDecimal price;
    private Instant created;
    private Instant updated;
}

package com.sample.shoppingcart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "product")
public class Product {
    @Id
    private UUID id;
    private String description;
    private String category;
    private BigDecimal price;
    private Instant created;
    private Instant updated;
    @ManyToMany(mappedBy="products")
    private Set<ShoppingCart> shoppingCarts = new HashSet();
}

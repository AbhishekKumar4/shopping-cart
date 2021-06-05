package com.sample.shoppingcart.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String countryCode;
    private String currency;
    private Instant created;
    private Instant updated;
    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = { @JoinColumn(name = "fk_cart") },
            inverseJoinColumns = { @JoinColumn(name = "fk_product") })
    private Set<Product> products = new HashSet();
}

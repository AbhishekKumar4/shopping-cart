package com.sample.shoppingcart.dto;

import java.time.Instant;
import java.util.Set;

public class ShoppingCartDTO {
    private Long id;
    private String countryCode;
    private String currency;
    private Instant created = Instant.now();
    private Instant updated = Instant.now();
    private Set<ProductDTO> products;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }
}

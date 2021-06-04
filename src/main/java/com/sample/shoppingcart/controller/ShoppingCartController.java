package com.sample.shoppingcart.controller;

import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/api/carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(final ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCartDTO> createShoppingCart(@RequestBody final ShoppingCartDTO shoppingCartDTO) {
        return null;
    }

    @GetMapping(value = "/{cartId}")
    public ResponseEntity<ShoppingCartDTO> getShoppingCart(@PathVariable final Long cartId) {
        return null;
    }
}

package com.sample.shoppingcart.controller;

import com.sample.shoppingcart.dto.ProductDTO;
import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/carts")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(final ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCartDTO> createShoppingCart(@RequestBody final ShoppingCartDTO shoppingCartDto) {
        ShoppingCartDTO shoppingCartCreated = shoppingCartService.createShoppingCart(shoppingCartDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(shoppingCartCreated);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<ShoppingCartDTO> getShoppingCart(@PathVariable final Long cartId) {
        ShoppingCartDTO shoppingCartDto = shoppingCartService.getShoppingCart(cartId);
        return ResponseEntity.ok(shoppingCartDto);
    }

    @PutMapping("/{cartId}/products")
    public ResponseEntity<ProductDTO> addProduct(@PathVariable final Long cartId,
                                     @RequestBody final ProductDTO productDto) {
        ProductDTO addedProduct = shoppingCartService.addProduct(cartId, productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
    }

    @GetMapping("/{cartId}/products/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final Long cartId,
                                     @PathVariable final UUID productId) {
        ProductDTO productDto = shoppingCartService.getProduct(cartId, productId);
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{cartId}/products/{productId}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable final Long cartId,
                                     @PathVariable final UUID productId) {
        ProductDTO deletedProduct = shoppingCartService.deleteProduct(cartId, productId);
        return ResponseEntity.ok(deletedProduct);
    }
}

package com.sample.shoppingcart.service;

import com.sample.shoppingcart.dto.CreateShoppingCartRequestDTO;
import com.sample.shoppingcart.dto.ProductDTO;
import com.sample.shoppingcart.dto.ShoppingCartDTO;

import java.util.UUID;

public interface ShoppingCartService {

    ShoppingCartDTO createShoppingCart(CreateShoppingCartRequestDTO createShoppingCartRequestDTO);

    ShoppingCartDTO getShoppingCart(Long cartId);

    ProductDTO addProduct(final Long cartId, ProductDTO productDTO);

    ProductDTO getProduct(Long cartId, final UUID productId);

    ProductDTO deleteProduct(Long cartId, final UUID productId);
}

package com.sample.shoppingcart.util;

import com.sample.shoppingcart.dto.ProductDTO;
import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.entity.Product;
import com.sample.shoppingcart.entity.ShoppingCart;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TestUtils {

    public static ShoppingCartDTO createShoppingCartDto() {
        ShoppingCartDTO shoppingCartDto = new ShoppingCartDTO();
        shoppingCartDto.setId(1L);
        shoppingCartDto.setCountryCode("IN");
        shoppingCartDto.setCurrency("INR");
        ProductDTO productDto = new ProductDTO();
        productDto.setId(UUID.randomUUID());
        productDto.setCategory("Menz");
        productDto.setDescription("Levis Jeans");

        Set<ProductDTO> set = new HashSet();
        set.add(productDto);

        shoppingCartDto.setProducts(set);
        return shoppingCartDto;
    }

    public static ShoppingCart createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1L);
        shoppingCart.setCountryCode("IN");
        shoppingCart.setCurrency("INR");
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setCategory("Menz");
        product.setDescription("Levis Jeans");

        Set<Product> set = new HashSet();
        set.add(product);

        shoppingCart.setProducts(set);
        return shoppingCart;
    }

    public static ProductDTO createProductDto() {
        ProductDTO productDto = new ProductDTO();
        productDto.setDescription("Product Desc");
        productDto.setCategory("Category");
        return productDto;
    }
    public static Product createProduct() {
        Product product = new Product();
        product.setDescription("Product Desc");
        product.setCategory("Category");
        return product;
    }
}

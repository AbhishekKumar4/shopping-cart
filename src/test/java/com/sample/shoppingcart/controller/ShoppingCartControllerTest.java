package com.sample.shoppingcart.controller;

import com.sample.shoppingcart.dto.ProductDTO;
import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.service.ShoppingCartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartControllerTest {

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    @Mock
    private ShoppingCartService shoppingCartService;

    @Test
    public void createShoppingCartTest() {
        // Create request DTO
        ShoppingCartDTO shoppingCartDto = createShoppingCartDto();
        Mockito.when(shoppingCartService.createShoppingCart(Mockito.any(ShoppingCartDTO.class))).thenReturn(shoppingCartDto);
        ResponseEntity<ShoppingCartDTO> response =  shoppingCartController.createShoppingCart(shoppingCartDto);
        Assertions.assertEquals(response.getStatusCodeValue(), 201);
    }


    @Test
    public void getShoppingCartTest() {
        ShoppingCartDTO shoppingCartDto = createShoppingCartDto();
        Mockito.when(shoppingCartService.getShoppingCart(Mockito.anyLong())).thenReturn(shoppingCartDto);
        ResponseEntity<ShoppingCartDTO> response =  shoppingCartController.getShoppingCart(1L);
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    public void addProductTest() {
        ProductDTO productDto = createProductDto();
        Long cartId = 1L;
        Mockito.when(shoppingCartService.addProduct(Mockito.anyLong(), Mockito.any(ProductDTO.class))).thenReturn(productDto);
        ResponseEntity<ProductDTO> response =  shoppingCartController.addProduct(1L, productDto);
        Assertions.assertEquals(response.getStatusCodeValue(), 201);
    }

    @Test
    public void getProductTest() {
        ProductDTO productDto = createProductDto();
        Mockito.when(shoppingCartService.getProduct(Mockito.anyLong(), Mockito.any(UUID.class))).thenReturn(productDto);
        ResponseEntity<ProductDTO> response =  shoppingCartController.getProduct(1L, UUID.randomUUID());
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    public void deleteProductTest() {
        ProductDTO productDto = createProductDto();
        Mockito.when(shoppingCartService.deleteProduct(Mockito.anyLong(), Mockito.any(UUID.class))).thenReturn(productDto);
        ResponseEntity<ProductDTO> response =  shoppingCartController.deleteProduct(1L, UUID.randomUUID());
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    private static ShoppingCartDTO createShoppingCartDto() {
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

    private static ProductDTO createProductDto() {
        ProductDTO productDto = new ProductDTO();
        productDto.setDescription("Product Desc");
        productDto.setCategory("Category");
        return productDto;
    }
}

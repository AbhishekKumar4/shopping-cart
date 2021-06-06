package com.sample.shoppingcart.controller;

import com.sample.shoppingcart.dto.ProductDTO;
import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.service.ShoppingCartService;
import com.sample.shoppingcart.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartControllerTest {

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    @Mock
    private ShoppingCartService shoppingCartService;

    @Test
    public void createShoppingCartTest() {
        ShoppingCartDTO shoppingCartDto = TestUtils.createShoppingCartDto();
        Mockito.when(shoppingCartService.createShoppingCart(Mockito.any(ShoppingCartDTO.class))).thenReturn(shoppingCartDto);
        ResponseEntity<ShoppingCartDTO> response =  shoppingCartController.createShoppingCart(shoppingCartDto);
        Assertions.assertEquals(response.getStatusCodeValue(), 201);
    }

    @Test
    public void getShoppingCartTest() {
        ShoppingCartDTO shoppingCartDto = TestUtils.createShoppingCartDto();
        Mockito.when(shoppingCartService.getShoppingCart(Mockito.anyLong())).thenReturn(shoppingCartDto);
        ResponseEntity<ShoppingCartDTO> response =  shoppingCartController.getShoppingCart(1L);
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    public void addProductTest() {
        ProductDTO productDto = TestUtils.createProductDto();
        Long cartId = 1L;
        Mockito.when(shoppingCartService.addProduct(Mockito.anyLong(), Mockito.any(ProductDTO.class))).thenReturn(productDto);
        ResponseEntity<ProductDTO> response =  shoppingCartController.addProduct(1L, productDto);
        Assertions.assertEquals(response.getStatusCodeValue(), 201);
    }

    @Test
    public void getProductTest() {
        ProductDTO productDto = TestUtils.createProductDto();
        Mockito.when(shoppingCartService.getProduct(Mockito.anyLong(), Mockito.any(UUID.class))).thenReturn(productDto);
        ResponseEntity<ProductDTO> response =  shoppingCartController.getProduct(1L, UUID.randomUUID());
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }

    @Test
    public void deleteProductTest() {
        ProductDTO productDto = TestUtils.createProductDto();
        Mockito.when(shoppingCartService.deleteProduct(Mockito.anyLong(), Mockito.any(UUID.class))).thenReturn(productDto);
        ResponseEntity<ProductDTO> response =  shoppingCartController.deleteProduct(1L, UUID.randomUUID());
        Assertions.assertEquals(response.getStatusCodeValue(), 200);
    }
}

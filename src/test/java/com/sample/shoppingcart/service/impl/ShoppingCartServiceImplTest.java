package com.sample.shoppingcart.service.impl;

import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.entity.Product;
import com.sample.shoppingcart.entity.ShoppingCart;
import com.sample.shoppingcart.repository.ProductRepository;
import com.sample.shoppingcart.repository.ShoppingCartRepository;
import com.sample.shoppingcart.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartServiceImplTest {

    @InjectMocks
    private ShoppingCartServiceImpl shoppingCartService;
    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @Mock
    private ProductRepository productRepository;

    @Test
    public void createShoppingCartTest() {
        ShoppingCartDTO shoppingCartDto = TestUtils.createShoppingCartDto();
        ShoppingCart shoppingCart = TestUtils.createShoppingCart();
        Product product = TestUtils.createProduct();
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        Mockito.when(shoppingCartRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(shoppingCart);
        ShoppingCartDTO savedCart = shoppingCartService.createShoppingCart(shoppingCartDto);
        Assertions.assertEquals(savedCart.getId(), 1L);
    }

}

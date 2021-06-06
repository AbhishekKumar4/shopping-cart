package com.sample.shoppingcart.service.impl;

import com.sample.shoppingcart.dto.ProductDTO;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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

    @Test
    public void getShoppingCartTest() {
        ShoppingCart shoppingCart = TestUtils.createShoppingCart();
        Mockito.when(shoppingCartRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(shoppingCart));
        ShoppingCartDTO shoppingCartDto = shoppingCartService.getShoppingCart(1L);
        Assertions.assertEquals(shoppingCartDto.getId(), 1L);
    }

    @Test
    public void addProductTest() {
        ShoppingCart shoppingCart = TestUtils.createShoppingCart();
        Product product = TestUtils.createProduct();
        ProductDTO productDto = TestUtils.createProductDto();

        Mockito.when(shoppingCartRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(shoppingCart));
        Mockito.when(productRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
        Mockito.when(shoppingCartRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(shoppingCart);

        ProductDTO addedProduct = shoppingCartService.addProduct(1L, productDto);
        Assertions.assertEquals(addedProduct.getId(), productDto.getId());
    }

    @Test
    public void getProductTest() {
        ProductDTO productDto = TestUtils.createProductDto();
        ShoppingCart shoppingCart = TestUtils.createShoppingCart();
        Product product = TestUtils.createProduct();
        product.setId(productDto.getId());
        Set<Product> productSet = new HashSet<>();
        productSet.add(product);
        shoppingCart.setProducts(productSet);

        Mockito.when(shoppingCartRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(shoppingCart));
        ProductDTO addedProduct = shoppingCartService.getProduct(1L, productDto.getId());
        Assertions.assertEquals(addedProduct.getId(), productDto.getId());
    }

    @Test
    public void deleteProductTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1L);
        shoppingCart.setCountryCode("IN");
        shoppingCart.setCurrency("INR");
        Product product = new Product();
        UUID productID = UUID.randomUUID();
        product.setId(productID);
        product.setCategory("Menz");
        product.setDescription("Levis Jeans");

        Set<Product> set = new HashSet();
        set.add(product);

        shoppingCart.setProducts(set);

        Mockito.when(shoppingCartRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(shoppingCart));
        Mockito.when(shoppingCartRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(shoppingCart);
        Mockito.doNothing().when(productRepository).deleteById(Mockito.any(UUID.class));
        ProductDTO deletedProductDto = shoppingCartService.deleteProduct(1L, productID);
        Assertions.assertEquals(deletedProductDto.getId(), productID);
    }

}

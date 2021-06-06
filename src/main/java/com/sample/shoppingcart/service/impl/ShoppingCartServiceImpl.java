package com.sample.shoppingcart.service.impl;

import com.sample.shoppingcart.dto.ProductDTO;
import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.entity.Product;
import com.sample.shoppingcart.entity.ShoppingCart;
import com.sample.shoppingcart.mapper.ProductMapper;
import com.sample.shoppingcart.mapper.ShoppingCartMapper;
import com.sample.shoppingcart.repository.ProductRepository;
import com.sample.shoppingcart.repository.ShoppingCartRepository;
import com.sample.shoppingcart.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartServiceImpl(final ShoppingCartRepository shoppingCartRepository, final ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCartEntity = ShoppingCartMapper.INSTANCE.map(shoppingCartDTO);
        Set<Product> productSet = shoppingCartEntity.getProducts();
        productSet.forEach(productRepository::save);
        ShoppingCart savedEntity = shoppingCartRepository.save(shoppingCartEntity);
        return ShoppingCartMapper.INSTANCE.map(shoppingCartEntity);
    }

    @Override
    public ShoppingCartDTO getShoppingCart(Long cartId) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if(shoppingCartOptional.isPresent()) {
            return ShoppingCartMapper.INSTANCE.map(shoppingCartOptional.get());
        } else {
            throw new RuntimeException("Shopping Cart Doesn't Exists!!!");
        }
    }

    @Override
    public ProductDTO addProduct(Long cartId, ProductDTO productDTO) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if(shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCartEntity = shoppingCartOptional.get();
            Set<Product> productSet = shoppingCartEntity.getProducts();
            // Check if product already exists
            Product product = ProductMapper.INSTANCE.map(productDTO);
            Optional<Product> productEntityOptional = productRepository.findById(productDTO.getId());
            if(productEntityOptional.isPresent()) {
                Product productEntity = productEntityOptional.get();
                product.setCreated(productEntity.getCreated());
            }
            // Save the product
            Product savedProduct = productRepository.save(product);
            productSet.add(savedProduct);
            shoppingCartRepository.save(shoppingCartEntity);
            log.info("Shopping cart updated!!!!");
        } else {
            throw new RuntimeException("Shopping Cart Doesn't Exists!!!");
        }
        return productDTO;
    }

    @Override
    public ProductDTO getProduct(Long cartId, UUID productId) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if(shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            Set<Product> productSet = shoppingCart.getProducts();
            Optional<Product> matchingObject = productSet.stream().filter(p-> p.getId().equals(productId)).findFirst();
            if(matchingObject.isPresent()) {
                Product matchedProduct = matchingObject.get();
                return ProductMapper.INSTANCE.map(matchedProduct);
            }
            throw new RuntimeException("Product Does not exists in cart!!!");
        }
        throw new RuntimeException("Shopping Cart Doesn't Exists!!!");
    }

    @Override
    public ProductDTO deleteProduct(Long cartId, UUID productId) {
        Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
        if(shoppingCartOptional.isPresent()) {
            ShoppingCart shoppingCart = shoppingCartOptional.get();
            Set<Product> productSet = shoppingCart.getProducts();
            Optional<Product> matchingObject = productSet.stream().filter(p-> p.getId().equals(productId)).findFirst();
            if(matchingObject.isPresent()) {
                Product matchedProduct = matchingObject.get();
                productSet.remove(matchedProduct);
                shoppingCart.setProducts(productSet);
                // delete relation
                shoppingCartRepository.save(shoppingCart);
                // delete product
                productRepository.deleteById(matchedProduct.getId());
                log.info("Product removed from cart : {}", matchedProduct);
                return ProductMapper.INSTANCE.map(matchedProduct);
            }
            throw new RuntimeException("Product Does not exists in cart!!!");
        }
        throw new RuntimeException("Shopping Cart Doesn't Exists!!!");
    }
}

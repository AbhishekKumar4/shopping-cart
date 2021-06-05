package com.sample.shoppingcart.config;

import com.sample.shoppingcart.repository.ProductRepository;
import com.sample.shoppingcart.repository.ShoppingCartRepository;
import com.sample.shoppingcart.service.ShoppingCartService;
import com.sample.shoppingcart.service.impl.ShoppingCartServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.sample.shoppingcart"})
@EnableJpaRepositories("com.sample.shoppingcart.repository")
public class ApplicationConfig {

    @Bean
    public ShoppingCartService shoppingCartService(final ShoppingCartRepository shoppingCartRepository, final ProductRepository productRepository) {
        return new ShoppingCartServiceImpl(shoppingCartRepository, productRepository);
    }
}

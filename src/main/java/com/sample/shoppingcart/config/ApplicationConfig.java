package com.sample.shoppingcart.config;

import com.sample.shoppingcart.repository.ShoppingCartRepository;
import com.sample.shoppingcart.service.ShoppingCartService;
import com.sample.shoppingcart.service.impl.ShoppingCartServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sample.shoppingcart"})
public class ApplicationConfig {

    @Bean
    public ShoppingCartService shoppingCartService(final ShoppingCartRepository shoppingCartRepository) {
        return new ShoppingCartServiceImpl(shoppingCartRepository);
    }
}

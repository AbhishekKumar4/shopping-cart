package com.sample.shoppingcart.repository;


import com.sample.shoppingcart.entity.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}

package com.sample.shoppingcart.repository;

import com.sample.shoppingcart.entity.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

}

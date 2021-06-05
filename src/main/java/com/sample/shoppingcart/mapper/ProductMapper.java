package com.sample.shoppingcart.mapper;

import com.sample.shoppingcart.dto.ProductDTO;
import com.sample.shoppingcart.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO map(Product product);

    Product map(ProductDTO productDTO);
}

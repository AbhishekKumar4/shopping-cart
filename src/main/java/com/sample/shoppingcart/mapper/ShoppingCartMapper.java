package com.sample.shoppingcart.mapper;

import com.sample.shoppingcart.dto.ShoppingCartDTO;
import com.sample.shoppingcart.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface ShoppingCartMapper {

    ShoppingCartMapper INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    ShoppingCart map(ShoppingCartDTO shoppingCartDTO);

    ShoppingCartDTO map(ShoppingCart shoppingCart);
}

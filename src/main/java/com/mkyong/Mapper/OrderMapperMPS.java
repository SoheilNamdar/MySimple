package com.mkyong.Mapper;

import com.mkyong.DTO.OrderDTO;
import com.mkyong.Entity.Order;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapperMPS {

    OrderDTO toDTO(Order customer);
    Order toEntity(OrderDTO customerDTO);

    default List<OrderDTO> toDTO(List<Order> customers){
        return customers.stream().map(customerDTO -> toDTO(customerDTO)).collect(Collectors.toList());

    }
}

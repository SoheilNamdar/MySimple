package com.mkyong.mapper;

import com.mkyong.dto.OrderDetailDTO;
import com.mkyong.entity.OrderDetail;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderDetailMapperMPS {

    OrderDetailDTO toDTO(OrderDetail orderDetail);
    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);

    default List<OrderDetailDTO> toDTO(List<OrderDetail> orderDetails){
        return orderDetails.stream().map(orderDetailDTO -> toDTO(orderDetailDTO)).collect(Collectors.toList());

    }
}

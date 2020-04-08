package com.mkyong.mapper;

import com.mkyong.dto.CustomerDTO;
import com.mkyong.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CustomerMapperMPS {

    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);

    default List<CustomerDTO> toDTO(List<Customer> customers){
        return customers.stream().map(customerDTO -> toDTO(customerDTO)).collect(Collectors.toList());

    }
}

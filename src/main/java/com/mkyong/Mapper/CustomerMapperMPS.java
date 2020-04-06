package com.mkyong.Mapper;

import com.mkyong.DTO.CustomerDTO;
import com.mkyong.Entity.Customer;
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

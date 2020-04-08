package com.mkyong.service;

import com.mkyong.dto.CustomerDTO;
import com.mkyong.mapper.CustomerMapperMPS;
import com.mkyong.repository.CustomerRepository;
import com.mkyong.error.NotFoundException.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapperMPS customerMapper;

    // Find
    public List<CustomerDTO> findAll() {
        return customerMapper.toDTO(customerRepository.findAll());
    }

    // Find
    public CustomerDTO findOne(Long id) {
        return customerMapper.toDTO(customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id)));
    }

    //Save
    public CustomerDTO save(CustomerDTO newCustomerDTO) {
        return customerMapper.toDTO(customerRepository.save(customerMapper.toEntity(newCustomerDTO)));
    }

    //update
    public CustomerDTO update(CustomerDTO customerDTO, Long id) {

        return customerMapper.toDTO(customerRepository.findById(id)
                .map(x -> {
                    x.setId(customerDTO.getId());
                    x.setDeliveryAddress(customerDTO.getDeliveryAddress());
                    x.setContact(customerDTO.getContact());
                    x.setActive(customerDTO.getActive());
                    return customerRepository.save(x);
                })
                .orElseThrow(() -> new CustomerNotFoundException(id)));
    }

    //delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

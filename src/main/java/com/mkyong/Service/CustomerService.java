package com.mkyong.Service;

import com.mkyong.DTO.CustomerDTO;
import com.mkyong.Mapper.CustomerMapperMPS;
import com.mkyong.Repository.CustomerRepository;
import com.mkyong.error.NotFoundException.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    // Save
    public CustomerDTO newCustomer(CustomerDTO newCustomerDTO) {

        return customerMapper.toDTO(customerRepository.save(customerMapper.toEntity(newCustomerDTO)));
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
    @PutMapping("/customers")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {

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

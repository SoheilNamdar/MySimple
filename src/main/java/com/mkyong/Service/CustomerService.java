package com.mkyong.Service;

import com.mkyong.DTO.CreditDTO;
import com.mkyong.DTO.CustomerDTO;
import com.mkyong.DTO.ItemDTO;
import com.mkyong.Entity.Customer;
import com.mkyong.Entity.Item;
import com.mkyong.Mapper.CreditMapperMPS;
import com.mkyong.Mapper.CustomerMapperMPS;
import com.mkyong.Repository.CreditRepository;
import com.mkyong.Repository.CustomerRepository;
import com.mkyong.error.NotFoundException.CreditNotFoundException;
import com.mkyong.error.NotFoundException.CustomerNotFoundException;
import com.mkyong.error.NotFoundException.ItemNotFoundException;
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
    public CustomerDTO save(Customer newCustomer) {
        return customerMapper.toDTO(customerRepository.save(newCustomer));
    }

    //update
    @PutMapping("/customers")
    public CustomerDTO update(@RequestBody Customer customer, @PathVariable Long id) {

        return customerMapper.toDTO(customerRepository.findById(id)
                .map(x -> {
                    x.setId(customer.getId());
                    x.setDeliveryAddress(customer.getDeliveryAddress());
                    x.setContact(customer.getContact());
                    x.setActive(customer.getActive());
                    return customerRepository.save(x);
                })
                .orElseThrow(() -> new CustomerNotFoundException(id)));
    }

    //delete
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

package com.mkyong.controller;

import com.mkyong.dto.CustomerDTO;
import com.mkyong.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Find
    @GetMapping("/customers")
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    // Find
    @GetMapping("/customers/{id}")
    public CustomerDTO findOne(@PathVariable Long id) {
        return customerService.findOne(id);
    }

    // Save
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO save(@Valid @RequestBody CustomerDTO newCustomerDTO) {

        return customerService.save(newCustomerDTO);
    }

    //update
    @PutMapping("/customers")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO) {

        return customerService.update(customerDTO,new CustomerDTO().getId());
    }

    //delete
    @DeleteMapping("/customers")
    public void deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);
    }

}

package com.mkyong.Controller;

import com.mkyong.DTO.CustomerDTO;
import com.mkyong.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Save
    @PostMapping("/customers")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO newCustomer(@RequestBody CustomerDTO newCustomerDTO) {
        return customerService.newCustomer(newCustomerDTO);
    }

    // Find
    @GetMapping("/customers")
    public CustomerDTO findOne(@RequestParam("id") Long id) {
        return customerService.findOne(id);
    }

    // Save
    @PutMapping("/customers")
    public CustomerDTO save(@RequestBody CustomerDTO newCustomerDTO) {

        return customerService.save(newCustomerDTO);
    }

    //update
    @PutMapping("/customers")
    public CustomerDTO update(@RequestBody CustomerDTO newCustomerDTO, @RequestParam Long id) {

        return customerService.update(newCustomerDTO,id);
    }

    //delete
    @DeleteMapping("/customers")
    void deleteCustomer(@RequestParam("id") Long id) {
        customerService.deleteCustomer(id);
    }

}

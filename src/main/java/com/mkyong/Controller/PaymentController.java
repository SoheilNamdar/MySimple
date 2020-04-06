package com.mkyong.Controller;

import com.mkyong.DTO.PaymentDTO;
import com.mkyong.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService itemService;

    // Find
    @GetMapping("/items")
    public List<PaymentDTO> findAll() {
        return itemService.findAll();
    }

    // Save
    @PostMapping("/items")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDTO newPayment(@RequestBody PaymentDTO newPaymentDTO) {
        return itemService.newPayment(newPaymentDTO);
    }

    // Find
    @GetMapping("/items")
    public PaymentDTO findOne(@RequestParam("id") Long id) {
        return itemService.findOne(id);
    }

    // Save
    @PutMapping("/items")
    public PaymentDTO save(@RequestBody PaymentDTO newPaymentDTO) {

        return itemService.save(newPaymentDTO);
    }

    //update
    @PutMapping("/items")
    public PaymentDTO update(@RequestBody PaymentDTO newPaymentDTO, @RequestParam("id") Long id) {

        return itemService.update(newPaymentDTO,id);
    }

    //delete
    @DeleteMapping("/items")
    void deletePayment(@RequestParam("id") Long id) {
        itemService.deletePayment(id);
    }

}

package com.mkyong.controller;

import com.mkyong.dto.PaymentDTO;
import com.mkyong.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Find
    @GetMapping("/payments")
    public List<PaymentDTO> findAll() {
        return paymentService.findAll();
    }

    // Find
    @GetMapping("/payments/{id}")
    public PaymentDTO findOne(@PathVariable Long id) {
        return paymentService.findOne(id);
    }

    // Save
    @PostMapping("/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDTO save(@RequestBody PaymentDTO newPaymentDTO) {

        return paymentService.save(newPaymentDTO);
    }

    //update
    @PutMapping("/payments")
    public PaymentDTO update(@RequestBody PaymentDTO paymentDTO) {

        return paymentService.update(paymentDTO,new PaymentDTO().getId());
    }

    //delete
    @DeleteMapping("/payments")
    void deletePayment(@RequestParam Long id) {
        paymentService.deletePayment(id);
    }

}

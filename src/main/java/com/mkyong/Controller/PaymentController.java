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
    private PaymentService paymentService;

    // Find
    @GetMapping("/payments")
    public List<PaymentDTO> findAll() {
        return paymentService.findAll();
    }

    // Save
    @PostMapping("/payments")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDTO newPayment(@RequestBody PaymentDTO newPaymentDTO) {
        return paymentService.newPayment(newPaymentDTO);
    }

    // Find
    @GetMapping("/payments/{id}")
    public PaymentDTO findOne(@PathVariable Long id) {
        return paymentService.findOne(id);
    }

    // Save
    @PutMapping("/payments")
    public PaymentDTO save(@RequestBody PaymentDTO newPaymentDTO) {

        return paymentService.save(newPaymentDTO);
    }

    //update
    @PutMapping("/payments")
    public PaymentDTO update(@RequestBody PaymentDTO newPaymentDTO, @RequestParam Long id) {

        return paymentService.update(newPaymentDTO,id);
    }

    //delete
    @DeleteMapping("/payments")
    void deletePayment(@RequestParam Long id) {
        paymentService.deletePayment(id);
    }

}

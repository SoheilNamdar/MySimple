package com.mkyong.Service;

import com.mkyong.DTO.PaymentDTO;
import com.mkyong.Entity.Payment;
import com.mkyong.Mapper.PaymentMapperMPS;
import com.mkyong.Repository.PaymentRepository;
import com.mkyong.error.NotFoundException.PaymentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapperMPS paymentMapper;

    // Find
    public List<PaymentDTO> findAll() {
        return paymentMapper.toDTO(paymentRepository.findAll());
    }

    // Save
    public PaymentDTO newPayment(PaymentDTO newPaymentDTO) {

        return paymentMapper.toDTO(paymentRepository.save(paymentMapper.toEntity(newPaymentDTO)));
    }

    // Find
    public PaymentDTO findOne(Long id) {
        return paymentMapper.toDTO(paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id)));
    }

    //Save
    public PaymentDTO save(Payment newPayment) {
        return paymentMapper.toDTO(paymentRepository.save(newPayment));
    }

    //update
    @PutMapping("/payments")
    public PaymentDTO update(@RequestBody Payment payment, @PathVariable Long id) {

        return paymentMapper.toDTO(paymentRepository.findById(id)
                .map(x -> {
                    x.setId(payment.getId());
                    x.setAmount(payment.getAmount());
                    return paymentRepository.save(x);
                })
                .orElseThrow(() -> new PaymentNotFoundException(id)));
    }

    //delete
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}

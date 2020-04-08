package com.mkyong.service;

import com.mkyong.dto.PaymentDTO;
import com.mkyong.mapper.PaymentMapperMPS;
import com.mkyong.repository.PaymentRepository;
import com.mkyong.error.NotFoundException.PaymentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PaymentDTO save(PaymentDTO newPayment) {
        return paymentMapper.toDTO(paymentRepository.save(paymentMapper.toEntity(newPayment)));
    }

    //update
    public PaymentDTO update(PaymentDTO payment, Long id) {

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

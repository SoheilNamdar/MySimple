package com.mkyong.mapper;

import com.mkyong.dto.PaymentDTO;
import com.mkyong.entity.Payment;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PaymentMapperMPS {

    PaymentDTO toDTO(Payment payment);
    Payment toEntity(PaymentDTO paymentDTO);

    default List<PaymentDTO> toDTO(List<Payment> payments){
        return payments.stream().map(paymentDTO -> toDTO(paymentDTO)).collect(Collectors.toList());

    }
}

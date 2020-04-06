package com.mkyong.Mapper;

import com.mkyong.DTO.CreditDTO;
import com.mkyong.Entity.Credit;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CreditMapperMPS {

    CreditDTO toDTO(Credit credit);
    Credit toEntity(CreditDTO creditDTO);

    default List<CreditDTO> toDTO(List<Credit> credits){
        return credits.stream().map(creditDTO -> toDTO(creditDTO)).collect(Collectors.toList());

    }
}

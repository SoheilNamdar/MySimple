package com.mkyong.Mapper;

import com.mkyong.DTO.WireTransferDTO;
import com.mkyong.Entity.WireTransfer;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface WireTransferMapperMPS {

    WireTransferDTO toDTO(WireTransfer wireTransfer);
    WireTransfer toEntity(WireTransferDTO wireTransferDTO);

    default List<WireTransferDTO> toDTO(List<WireTransfer> wireTransfers){
        return wireTransfers.stream().map(wireTransferDTO -> toDTO(wireTransferDTO)).collect(Collectors.toList());

    }
}

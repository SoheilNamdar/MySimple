package com.mkyong.service;

import com.mkyong.dto.WireTransferDTO;
import com.mkyong.mapper.WireTransferMapperMPS;
import com.mkyong.repository.WireTransferRepository;
import com.mkyong.error.NotFoundException.WireTransferNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WireTransferService {

    @Autowired
    private WireTransferRepository wireTransferRepository;

    @Autowired
    private WireTransferMapperMPS wireTransferMapper;

    // Find
    public List<WireTransferDTO> findAll() {
        return wireTransferMapper.toDTO(wireTransferRepository.findAll());
    }

    // Find
    public WireTransferDTO findOne(Long id) {
        return wireTransferMapper.toDTO(wireTransferRepository.findById(id)
                .orElseThrow(() -> new WireTransferNotFoundException(id)));
    }

    //Save
    public WireTransferDTO save(WireTransferDTO newWireTransfer) {
        return wireTransferMapper.toDTO(wireTransferRepository.save(wireTransferMapper.toEntity(newWireTransfer)));
    }

    //update
    public WireTransferDTO update(WireTransferDTO wireTransfer, Long id) {

        return wireTransferMapper.toDTO(wireTransferRepository.findById(id)
                .map(x -> {
                    x.setId(wireTransfer.getId());
                    x.setBankID(wireTransfer.getBankID());
                    x.setBankName(wireTransfer.getBankName());
                    return wireTransferRepository.save(x);
                })
                .orElseThrow(() -> new WireTransferNotFoundException(id)));
    }

    //delete
    public void deleteWireTransfer(Long id) {
        wireTransferRepository.deleteById(id);
    }
}

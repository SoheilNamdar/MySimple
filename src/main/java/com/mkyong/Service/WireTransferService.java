package com.mkyong.Service;

import com.mkyong.DTO.WireTransferDTO;
import com.mkyong.Entity.WireTransfer;
import com.mkyong.Mapper.WireTransferMapperMPS;
import com.mkyong.Repository.WireTransferRepository;
import com.mkyong.error.NotFoundException.WireTransferNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // Save
    public WireTransferDTO newWireTransfer(WireTransfer newWireTransfer) {

        return wireTransferMapper.toDTO(wireTransferRepository.save(newWireTransfer));
    }

    // Find
    public WireTransferDTO findOne(Long id) {
        return wireTransferMapper.toDTO(wireTransferRepository.findById(id)
                .orElseThrow(() -> new WireTransferNotFoundException(id)));
    }

    //Save
    public WireTransferDTO save(WireTransfer newWireTransfer) {
        return wireTransferMapper.toDTO(wireTransferRepository.save(newWireTransfer));
    }

    //update
    @PutMapping("/wireTransfers")
    public WireTransferDTO update(@RequestBody WireTransfer wireTransfer, @PathVariable Long id) {

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

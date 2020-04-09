package com.mkyong.controller;

import com.mkyong.dto.WireTransferDTO;
import com.mkyong.service.WireTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WireTransferController {

    @Autowired
    private WireTransferService wireTransferService;

    // Find
    @GetMapping("/wireTransfers")
    public List<WireTransferDTO> findAll() {
        return wireTransferService.findAll();
    }

    // Find
    @GetMapping("/wireTransfers/{id}")
    public WireTransferDTO findOne(@PathVariable Long id) {
        return wireTransferService.findOne(id);
    }

    // Save
    @PostMapping("/wireTransfers")
    @ResponseStatus(HttpStatus.CREATED)
    public WireTransferDTO save(@Valid @RequestBody WireTransferDTO newWireTransferDTO) {

        return wireTransferService.save(newWireTransferDTO);
    }

    //update
    @PutMapping("/wireTransfers")
    public WireTransferDTO update(@RequestBody WireTransferDTO wireTransferDTO) {

        return wireTransferService.update(wireTransferDTO,new WireTransferDTO().getId());
    }

    //delete
    @DeleteMapping("/wireTransfers")
    public void deleteWireTransfer(@RequestParam Long id) {
        wireTransferService.deleteWireTransfer(id);
    }

}

package com.mkyong.Controller;

import com.mkyong.DTO.WireTransferDTO;
import com.mkyong.Service.WireTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Save
    @PostMapping("/wireTransfers")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public WireTransferDTO newWireTransfer(@RequestBody WireTransferDTO newWireTransferDTO) {
        return wireTransferService.newWireTransfer(newWireTransferDTO);
    }

    // Find
    @GetMapping("/wireTransfers/{id}")
    public WireTransferDTO findOne(@PathVariable Long id) {
        return wireTransferService.findOne(id);
    }

    // Save
    @PutMapping("/wireTransfers")
    public WireTransferDTO save(@RequestBody WireTransferDTO newWireTransferDTO) {

        return wireTransferService.save(newWireTransferDTO);
    }

    //update
    @PutMapping("/wireTransfers")
    public WireTransferDTO update(@RequestBody WireTransferDTO newWireTransferDTO, @RequestParam Long id) {

        return wireTransferService.update(newWireTransferDTO,id);
    }

    //delete
    @DeleteMapping("/wireTransfers")
    void deleteWireTransfer(@RequestParam Long id) {
        wireTransferService.deleteWireTransfer(id);
    }

}

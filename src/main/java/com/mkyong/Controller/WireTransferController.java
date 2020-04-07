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
    private WireTransferService itemService;

    // Find
    @GetMapping("/items")
    public List<WireTransferDTO> findAll() {
        return itemService.findAll();
    }

    // Save
    @PostMapping("/items")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public WireTransferDTO newWireTransfer(@RequestBody WireTransferDTO newWireTransferDTO) {
        return itemService.newWireTransfer(newWireTransferDTO);
    }

    // Find
    @GetMapping("/items")
    public WireTransferDTO findOne(@RequestParam Long id) {
        return itemService.findOne(id);
    }

    // Save
    @PutMapping("/items")
    public WireTransferDTO save(@RequestBody WireTransferDTO newWireTransferDTO) {

        return itemService.save(newWireTransferDTO);
    }

    //update
    @PutMapping("/items")
    public WireTransferDTO update(@RequestBody WireTransferDTO newWireTransferDTO, @RequestParam Long id) {

        return itemService.update(newWireTransferDTO,id);
    }

    //delete
    @DeleteMapping("/items")
    void deleteWireTransfer(@RequestParam Long id) {
        itemService.deleteWireTransfer(id);
    }

}

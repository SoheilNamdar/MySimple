package com.mkyong.controller;

import com.mkyong.dto.CreditDTO;
import com.mkyong.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CreditController {

    @Autowired
    private CreditService creditService;

    // Find
    @GetMapping("/credits")
    public List<CreditDTO> findAll() {
        return creditService.findAll();
    }

    // Find
    @GetMapping("/credits/{id}")
    public CreditDTO findOne(@PathVariable Long id) {
        return creditService.findOne(id);
    }

    // Save
    @PostMapping("/credits")
    public CreditDTO save(@Valid @RequestBody CreditDTO newCreditDTO) {

        return creditService.save(newCreditDTO);
    }

    //update
    @PutMapping("/credits")
    public CreditDTO update(@RequestBody CreditDTO creditDTO) {

        return creditService.update(creditDTO,new CreditDTO().getId());
    }

    //delete
    @DeleteMapping("/credits")
    public void deleteCredit(@RequestParam Long id) {
        creditService.deleteCredit(id);
    }
}

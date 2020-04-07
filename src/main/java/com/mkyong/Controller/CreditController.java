package com.mkyong.Controller;

import com.mkyong.DTO.CreditDTO;
import com.mkyong.Service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Save
    @PostMapping("/credits")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public CreditDTO newCredit(@RequestBody CreditDTO newCreditDTO) {
        return creditService.newCredit(newCreditDTO);
    }

    // Find
    @GetMapping("/credits")
    public CreditDTO findOne(@RequestParam Long id) {
        return creditService.findOne(id);
    }

    // Save
    @PutMapping("/credits")
    public CreditDTO save(@RequestBody CreditDTO newCreditDTO) {

        return creditService.save(newCreditDTO);
    }

    //update
    @PutMapping("/credits")
    public CreditDTO update(@RequestBody CreditDTO newCreditDTO, @RequestParam Long id) {

        return creditService.update(newCreditDTO,id);
    }

    //delete
    @DeleteMapping("/credits")
    void deleteCredit(@RequestParam Long id) {
        creditService.deleteCredit(id);
    }
}

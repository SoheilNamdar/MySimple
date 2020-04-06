package com.mkyong.Service;

import com.mkyong.DTO.CreditDTO;
import com.mkyong.DTO.CustomerDTO;
import com.mkyong.Entity.Credit;
import com.mkyong.Entity.Customer;
import com.mkyong.Mapper.CreditMapperMPS;
import com.mkyong.Repository.CreditRepository;
import com.mkyong.error.NotFoundException.CreditNotFoundException;
import com.mkyong.error.NotFoundException.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private CreditMapperMPS creditMapper;

    // Find
    public List<CreditDTO> findAll() {
        return creditMapper.toDTO(creditRepository.findAll());
    }

    // Save
    public CreditDTO newCredit(CreditDTO newCreditDTO) {

        return creditMapper.toDTO(creditRepository.save(creditMapper.toEntity(newCreditDTO)));
    }

    // Find
    public CreditDTO findOne(Long id) {
        return creditMapper.toDTO(creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException(id)));
    }

    //Save
    public CreditDTO save(Credit newCredit) {
        return creditMapper.toDTO(creditRepository.save(newCredit));
    }

    //update
    @PutMapping("/credits")
    public CreditDTO update(@RequestBody Credit credit, @PathVariable Long id) {

        return creditMapper.toDTO(creditRepository.findById(id)
                .map(x -> {
                    x.setId(credit.getId());
                    x.setNumber(credit.getNumber());
                    x.setType(credit.getType());
                    x.setExpireDate(credit.getExpireDate());
                    return creditRepository.save(x);
                })
                .orElseThrow(() -> new CreditNotFoundException(id)));
    }

    //delete
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}

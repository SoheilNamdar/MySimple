package com.mkyong.service;

import com.mkyong.dto.CreditDTO;
import com.mkyong.mapper.CreditMapperMPS;
import com.mkyong.repository.CreditRepository;
import com.mkyong.error.NotFoundException.CreditNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // Find
    public CreditDTO findOne(Long id) {
        return creditMapper.toDTO(creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException(id)));
    }

    //Save
    public CreditDTO save(CreditDTO newCreditDTO) {
        return creditMapper.toDTO(creditRepository.save(creditMapper.toEntity(newCreditDTO)));
    }

    //update
    public CreditDTO update(CreditDTO newCreditDTO, Long id) {

        return creditMapper.toDTO(creditRepository.findById(id)
                .map(x -> {
                    x.setId(newCreditDTO.getId());
                    x.setNumber(newCreditDTO.getNumber());
                    x.setType(newCreditDTO.getType());
                    x.setExpireDate(newCreditDTO.getExpireDate());
                    return creditRepository.save(x);
                })
                .orElseThrow(() -> new CreditNotFoundException(id)));
    }

    //delete
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}

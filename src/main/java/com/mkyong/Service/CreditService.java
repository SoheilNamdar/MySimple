package com.mkyong.Service;

import com.mkyong.DTO.CreditDTO;
import com.mkyong.Mapper.CreditMapperMPS;
import com.mkyong.Repository.CreditRepository;
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

    // Save
    public CreditDTO newCredit(CreditDTO newCreditDTO) {

        return creditMapper.toDTO(creditRepository.save(creditMapper.toEntity(newCreditDTO)));
    }

    // Find
    public CreditDTO findOne(Long id) {
        return creditMapper.toDTO(creditRepository.findById(id)
                .orElseThrow(() -> new CreditNotFoundException(id)));
    }

    // Save or update
    public CreditDTO saveOrUpdate(CreditDTO newCreditDTO, Long id) {

        return creditRepository.findById(id)
                .map(x -> {
                    x.setNumber(newCreditDTO.getNumber());
                    x.setType(newCreditDTO.getType());
                    x.setExpireDate(newCreditDTO.getExpireDate());
                    return creditMapper.toDTO(creditRepository.save(x));
                })
                .orElseGet(() -> {
                    newCreditDTO.setId(id);
                    return creditMapper.toDTO(creditRepository.save(creditMapper.toEntity(newCreditDTO)));
                });
    }

    //delete
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }
}

package com.mkyong.service;

import com.mkyong.dto.OrderDetailDTO;
import com.mkyong.mapper.OrderDetailMapperMPS;
import com.mkyong.repository.OrderDetailRepository;
import com.mkyong.error.NotFoundException.OrderDetailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailMapperMPS orderDetailMapper;

    // Find
    public List<OrderDetailDTO> findAll() {
        return orderDetailMapper.toDTO(orderDetailRepository.findAll());
    }

    // Find
    public OrderDetailDTO findOne(Long id) {
        return orderDetailMapper.toDTO(orderDetailRepository.findById(id)
                .orElseThrow(() -> new OrderDetailNotFoundException(id)));
    }

    //Save
    public OrderDetailDTO save(OrderDetailDTO newOrderDetailDTO) {
        return orderDetailMapper.toDTO(orderDetailRepository.save(orderDetailMapper.toEntity(newOrderDetailDTO)));
    }

    //update
    public OrderDetailDTO update(OrderDetailDTO orderDetailDTO, Long id) {

        return orderDetailMapper.toDTO(orderDetailRepository.findById(id)
                .map(x -> {
                    x.setId(orderDetailDTO.getId());
                    x.setName(orderDetailDTO.getName());
                    x.setTaxStatus(orderDetailDTO.getTaxStatus());
                    return orderDetailRepository.save(x);
                })
                .orElseThrow(() -> new OrderDetailNotFoundException(id)));
    }

    //delete
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}

package com.mkyong.Service;

import com.mkyong.DTO.OrderDetailDTO;
import com.mkyong.Entity.OrderDetail;
import com.mkyong.Mapper.OrderDetailMapperMPS;
import com.mkyong.Repository.OrderDetailRepository;
import com.mkyong.error.NotFoundException.OrderDetailNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    // Save
    public OrderDetailDTO newOrderDetail(OrderDetail newOrderDetail) {

        return orderDetailMapper.toDTO(orderDetailRepository.save(newOrderDetail));
    }

    // Find
    public OrderDetailDTO findOne(Long id) {
        return orderDetailMapper.toDTO(orderDetailRepository.findById(id)
                .orElseThrow(() -> new OrderDetailNotFoundException(id)));
    }

    //Save
    public OrderDetailDTO save(OrderDetail newOrderDetail) {
        return orderDetailMapper.toDTO(orderDetailRepository.save(newOrderDetail));
    }

    //update
    @PutMapping("/orderDetails")
    public OrderDetailDTO update(@RequestBody OrderDetail orderDetail, @PathVariable Long id) {

        return orderDetailMapper.toDTO(orderDetailRepository.findById(id)
                .map(x -> {
                    x.setId(orderDetail.getId());
                    x.setName(orderDetail.getName());
                    x.setTaxStatus(orderDetail.getTaxStatus());
                    return orderDetailRepository.save(x);
                })
                .orElseThrow(() -> new OrderDetailNotFoundException(id)));
    }

    //delete
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}

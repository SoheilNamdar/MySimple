package com.mkyong.service;

import com.mkyong.dto.OrderDTO;
import com.mkyong.mapper.OrderMapperMPS;
import com.mkyong.repository.OrderRepository;
import com.mkyong.error.NotFoundException.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapperMPS orderMapper;

    // Find
    public List<OrderDTO> findAll() {
        return orderMapper.toDTO(orderRepository.findAll());
    }

    // Find
    public OrderDTO findOne(Long id) {
        return orderMapper.toDTO(orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    //Save
    public OrderDTO save(OrderDTO newOrder) {
        return orderMapper.toDTO(orderRepository.save(orderMapper.toEntity(newOrder)));
    }

    //update
    public OrderDTO update(OrderDTO order, Long id) {

        return orderMapper.toDTO(orderRepository.findById(id)
                .map(x -> {
                    x.setId(order.getId());
                    x.setDate(order.getDate());
                    x.setStatus(order.getStatus());
                    return orderRepository.save(x);
                })
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    //delete
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

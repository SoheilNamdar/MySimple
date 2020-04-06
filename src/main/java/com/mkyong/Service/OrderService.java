package com.mkyong.Service;


import com.mkyong.DTO.OrderDTO;
import com.mkyong.Entity.Order;
import com.mkyong.Mapper.OrderMapperMPS;
import com.mkyong.Repository.OrderRepository;
import com.mkyong.error.NotFoundException.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    // Save
    public OrderDTO newOrder(OrderDTO newOrder) {

        return orderMapper.toDTO(orderRepository.save(orderMapper.toEntity(newOrder)));
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
    @PutMapping("/orders")
    public OrderDTO update(@RequestBody OrderDTO order, @PathVariable Long id) {

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

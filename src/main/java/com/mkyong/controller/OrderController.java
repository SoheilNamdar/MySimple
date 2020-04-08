package com.mkyong.controller;

import com.mkyong.dto.OrderDTO;
import com.mkyong.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Find
    @GetMapping("/orders")
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    // Find
    @GetMapping("/orders/{id}")
    public OrderDTO findOne(@PathVariable Long id) {
        return orderService.findOne(id);
    }

    // Save
    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO save(@RequestBody OrderDTO newOrderDTO) {

        return orderService.save(newOrderDTO);
    }

    //update
    @PutMapping("/orders")
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {

        return orderService.update(orderDTO,new OrderDTO().getId());
    }

    //delete
    @DeleteMapping("/orders")
    void deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
    }

}

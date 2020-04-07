package com.mkyong.Controller;

import com.mkyong.DTO.OrderDTO;
import com.mkyong.Service.OrderService;
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

    // Save
    @PostMapping("/orders")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO newOrder(@RequestBody OrderDTO newOrderDTO) {
        return orderService.newOrder(newOrderDTO);
    }

    // Find
    @GetMapping("/orders")
    public OrderDTO findOne(@RequestParam Long id) {
        return orderService.findOne(id);
    }

    // Save
    @PutMapping("/orders")
    public OrderDTO save(@RequestBody OrderDTO newOrderDTO) {

        return orderService.save(newOrderDTO);
    }

    //update
    @PutMapping("/orders")
    public OrderDTO update(@RequestBody OrderDTO newOrderDTO, @RequestParam Long id) {

        return orderService.update(newOrderDTO,id);
    }

    //delete
    @DeleteMapping("/orders")
    void deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
    }

}

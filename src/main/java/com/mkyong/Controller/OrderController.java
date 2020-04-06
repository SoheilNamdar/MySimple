package com.mkyong.Controller;

import com.mkyong.Repository.OrderRepository;
import com.mkyong.Entity.Order;
import com.mkyong.error.NotFoundException.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> findAll() { return orderRepository.findAll(); }

    // Save
    @PostMapping("/book")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public Order newOrder(@RequestBody Order newOrder) {
        return orderRepository.save(newOrder);
    }

    // Find
    @GetMapping("/order")
    public Order findOne(@RequestBody Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    //Save
    @PutMapping("/order")
    public Order save(@RequestBody Order newOrder) {
        return orderRepository.save(newOrder);
    }

    //update
    @PutMapping("/orders")
    public Order update(@RequestBody Order order, @PathVariable Long id) {

        return orderRepository.findById(id)
                .map(x -> {
                    x.setId(order.getId());
                    x.setDate(order.getDate());
                    x.setStatus(order.getStatus());
                    return orderRepository.save(x);
                })
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    //delete
    public void deleteBook(Long id) {
        orderRepository.deleteById(id);
    }

}

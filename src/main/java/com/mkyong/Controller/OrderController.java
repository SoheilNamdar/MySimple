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
    private OrderService itemService;

    // Find
    @GetMapping("/items")
    public List<OrderDTO> findAll() {
        return itemService.findAll();
    }

    // Save
    @PostMapping("/items")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO newOrder(@RequestBody OrderDTO newOrderDTO) {
        return itemService.newOrder(newOrderDTO);
    }

    // Find
    @GetMapping("/items")
    public OrderDTO findOne(@RequestParam Long id) {
        return itemService.findOne(id);
    }

    // Save
    @PutMapping("/items")
    public OrderDTO save(@RequestBody OrderDTO newOrderDTO) {

        return itemService.save(newOrderDTO);
    }

    //update
    @PutMapping("/items")
    public OrderDTO update(@RequestBody OrderDTO newOrderDTO, @RequestParam Long id) {

        return itemService.update(newOrderDTO,id);
    }

    //delete
    @DeleteMapping("/items")
    void deleteOrder(@RequestParam Long id) {
        itemService.deleteOrder(id);
    }

}

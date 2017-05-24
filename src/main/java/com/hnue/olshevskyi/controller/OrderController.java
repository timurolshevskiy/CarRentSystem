package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.dto.OrderDto;
import com.hnue.olshevskyi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/make")
    public String makeOrder(@RequestBody OrderDto orderDto) {
        return "order";
    }
}

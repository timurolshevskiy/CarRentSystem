package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.dto.OrderDto;
import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.OrderBill;
import com.hnue.olshevskyi.service.OrderService;
import com.hnue.olshevskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/make")
    public String makeOrder(@RequestBody OrderDto orderDto, Map<String, Object> model) {
        orderDto.setUser(userService.findUserById(21));
        Order order = orderService.makeOrder(orderDto);
        return fillInModelForOrderPage(model, order.getId());
    }

    @GetMapping("/confirm")
    public String confirmOrder(@PathVariable long orderId, Map<String, Object> model) {
        orderService.confirmOrder(orderId);
        return fillInModelForOrderPage(model, orderId);
    }

    @GetMapping("/pay")
    public String payForBill(@PathVariable long billId, Map<String, Object> model) {
        OrderBill orderBill = orderService.payForBill(billId);
        return fillInModelForOrderPage(model, orderBill.getOrder().getId());
    }

    @GetMapping("/billForDamages")
    public String billForDamages(@PathVariable long orderId, @PathVariable double cost, Map<String, Object> model) {
        OrderBill orderBill = orderService.billForDamages(orderId, cost);
        return fillInModelForOrderPage(model, orderBill.getOrder().getId());
    }

    @GetMapping("/cancel")
    public String cancelOrder(@PathVariable long orderId, @PathVariable String reason, Map<String, Object> model) {
        orderService.cancelOrder(orderId, reason);
        return fillInModelForOrderPage(model, orderId);
    }

    @GetMapping("/complete")
    public String completeOrder(@PathVariable long orderId, Map<String, Object> model) {
        orderService.completeOrder(orderId);
        return fillInModelForOrderPage(model, orderId);
    }

    /**
     * Returns view name.
     *
     * @return view name
     */
    private String fillInModelForOrderPage(Map<String, Object> model, long orderId) {
        Order order = orderService.findOrderById(orderId);
        model.put("order", order);
        model.put("bills", orderService.findBillsForOrder(order));
        return "order";
    }
}

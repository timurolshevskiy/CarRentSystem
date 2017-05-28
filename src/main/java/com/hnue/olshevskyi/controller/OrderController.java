package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.dto.OrderDto;
import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.OrderBill;
import com.hnue.olshevskyi.service.OrderService;
import com.hnue.olshevskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/make")
    @PreAuthorize("isAuthenticated()")
    public String makeOrder(OrderDto orderDto, Map<String, Object> model) {
        orderDto.setUser(userService.getCurrentUser());
        Order order = orderService.makeOrder(orderDto);
        return fillInModelForOrderPage(model, order.getId());
    }

    @GetMapping("/confirm")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    public String confirmOrder(@RequestParam long orderId, Map<String, Object> model) {
        orderService.confirmOrder(orderId);
        return fillInModelForOrderPage(model, orderId);
    }

    @GetMapping("/pay")
    @PreAuthorize("isAuthenticated()")
    public String payForBill(@RequestParam long billId, Map<String, Object> model) {
        OrderBill orderBill = orderService.payForBill(billId);
        return fillInModelForOrderPage(model, orderBill.getOrder().getId());
    }

    @GetMapping("/billForDamages")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    public String billForDamages(@RequestParam long orderId, @RequestParam double cost, @RequestParam String description, Map<String, Object> model) {
        OrderBill orderBill = orderService.billForDamages(orderId, cost, description);
        return fillInModelForOrderPage(model, orderBill.getOrder().getId());
    }

    @GetMapping("/cancel")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    public String cancelOrder(@RequestParam long orderId, @RequestParam String reason, Map<String, Object> model) {
        orderService.cancelOrder(orderId, reason);
        return fillInModelForOrderPage(model, orderId);
    }

    @GetMapping("/complete")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    public String completeOrder(@RequestParam long orderId, Map<String, Object> model) {
        orderService.completeOrder(orderId);
        return fillInModelForOrderPage(model, orderId);
    }

    @GetMapping("")
    @PreAuthorize("isAuthenticated()")
    public String getOrdersByUserId(@RequestParam long userId, Map<String, Object> model) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        model.put("user", userService.getCurrentUser());
        model.put("orders", orders);
        return "user";
    }

    @GetMapping("single")
    @PreAuthorize("isAuthenticated()")
    public String getOrderById(@RequestParam long id, Map<String, Object> model) {
        return fillInModelForOrderPage(model, id);
    }

    /**
     * Returns view name.
     *
     * @return view name
     */
    private String fillInModelForOrderPage(Map<String, Object> model, long orderId) {
        Order order = orderService.findOrderById(orderId);
        model.put("user", userService.getCurrentUser());
        model.put("order", order);
        model.put("bills", orderService.findBillsForOrder(order));
        return "order";
    }
}

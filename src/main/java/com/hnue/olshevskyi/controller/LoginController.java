package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.User;
import com.hnue.olshevskyi.service.OrderService;
import com.hnue.olshevskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/login")
    //@PreAuthorize("isAnonymous()")
    public String loginPage() {
        return "login";
    }

    @GetMapping("")
    public String home(Map<String, Object> model) {
        User user = userService.getCurrentUser();
        List<Order> orders = orderService.getOrdersByUserId(user.getId());
        model.put("user", user);
        model.put("orders", orders);
        return "redirect:/car/all";
    }

}

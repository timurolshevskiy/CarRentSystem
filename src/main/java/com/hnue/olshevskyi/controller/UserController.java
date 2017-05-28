package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.dto.UserRegistrationDto;
import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.User;
import com.hnue.olshevskyi.service.OrderService;
import com.hnue.olshevskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    public String getAllUsers(Map<String, Object> model) {
        model.put("user", userService.getCurrentUser());
        model.put("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PreAuthorize("isAnonymous()")
    public String registerUser(Map<String, Object> body, UserRegistrationDto userRegistrationDto) {
        User user = userService.registerUser(userRegistrationDto);
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return fillInModelForUserHomePage(body, user);
    }

    @GetMapping("/userHomePage")
    @PreAuthorize("isAuthenticated()")
    public String getUserHomePage(@RequestParam long id, Map<String, Object> model) {
        User user = userService.findUserById(id);
        return fillInModelForUserHomePage(model, user);
    }

    private String fillInModelForUserHomePage(Map<String, Object> model, User user) {
        model.put("user", user);
        List<Order> orders = orderService.getOrdersByUserId(user.getId());
        model.put("orders", orders);
        return "user";
    }
}

package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.model.Car;
import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public String getAllCars(@RequestParam String mark, @RequestParam String qualityClass, @RequestParam String sortBy, Map<String, Object> model) {
        List<Car> allCars = carService.getAllCars();
        model.put("message", allCars.size());
        model.put("cars", allCars);
        return "cars";
    }

    private String fillInModelForCarsPage(Map<String, Object> model, long orderId) {
        Order order = orderService.findOrderById(orderId);
        model.put("order", order);
        model.put("bills", orderService.findBillsForOrder(order));
        return "order";
    }

    private String fillInModelForSingleCar(Map<String, Object> model, long orderId) {
        Order order = orderService.findOrderById(orderId);
        model.put("order", order);
        model.put("bills", orderService.findBillsForOrder(order));
        return "order";
    }

}

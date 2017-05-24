package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.model.Car;
import com.hnue.olshevskyi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getAllCars(Map<String, Object> model) {
        List<Car> allCars = carService.getAllCars();
        model.put("message", allCars.size());
        model.put("cars", allCars);
        return "cars";
    }

}

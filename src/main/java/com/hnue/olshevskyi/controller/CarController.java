package com.hnue.olshevskyi.controller;

import com.hnue.olshevskyi.model.Car;
import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.User;
import com.hnue.olshevskyi.service.CarService;
import com.hnue.olshevskyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getAllCars(@RequestParam(required = false) String mark,
                             @RequestParam(required = false) String qualityClass,
                             @RequestParam(required = false) String sortBy,
                             Map<String, Object> model) {
        return fillInModelForCarsPage(model, mark, qualityClass, sortBy);
    }

    @GetMapping()
    public String getSingleCar(@RequestParam long id, Map<String, Object> model) {
        return fillInModelForSingleCar(model, id);
    }

    @PostMapping("/add")
    public String addCar(Car car, Map<String, Object> model) {
        carService.createCar(car);
        return "redirect:/car/all";
    }

    @GetMapping("/delete")
    public String deleteCar(long id, Map<String, Object> model) {
        carService.deleteCar(id);
        return "redirect:/car/all";
    }

    private String fillInModelForCarsPage(Map<String, Object> model, String mark, String qualityClass, String sortBy) {
        List<Car> cars = carService.getByFilterAndSort(mark, qualityClass, sortBy);
        model.put("cars", cars);
        model.put("user", userService.getCurrentUser());
        return "cars";
    }

    private String fillInModelForSingleCar(Map<String, Object> model, long carId) {
        Car car = carService.getCarById(carId);
        model.put("car", car);
        model.put("user", userService.getCurrentUser());
        return "car";
    }

}

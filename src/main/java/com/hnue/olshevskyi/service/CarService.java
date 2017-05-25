package com.hnue.olshevskyi.service;

import com.hnue.olshevskyi.dao.CarDao;
import com.hnue.olshevskyi.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarDao carDao;

    public List<Car> getAllCars() {
        return (List<Car>) carDao.findAll();
    }

    public Car getCarById(long id) {
        return carDao.findOne(id);
    }



}

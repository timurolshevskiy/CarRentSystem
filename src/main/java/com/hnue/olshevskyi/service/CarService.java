package com.hnue.olshevskyi.service;

import com.hnue.olshevskyi.dao.CarDao;
import com.hnue.olshevskyi.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Car> getByFilterAndSort(String mark, String qualityClass, String sortBy) {
        Sort sort = new Sort(sortBy == null ? "name" : sortBy);
        if (mark != null && qualityClass != null) {
            return carDao.findByMarkLikeAndQualityClassLike(mark, qualityClass, sort);
        }
        if (mark != null) {
            return carDao.findByMarkLike(mark, sort);
        }
        if (qualityClass != null) {
            return carDao.findByQualityClassLike(qualityClass, sort);
        }
        return carDao.findAll(sort);
    }

    public Car createCar(Car car) {
        car.setAvailable(true);
        return carDao.save(car);
    }

    public Car updateCar(Car car) {
        return carDao.save(car);
    }

    public void deleteCar(long id) {
        carDao.delete(id);
    }

}

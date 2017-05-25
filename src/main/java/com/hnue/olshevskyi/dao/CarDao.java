package com.hnue.olshevskyi.dao;

import com.hnue.olshevskyi.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends CrudRepository<Car, Long> {

    // создать 3 метода для фильтров (для всех сомбинаций)
    // и в каждый передавать объект Сорт
}

package com.hnue.olshevskyi.dao;

import com.hnue.olshevskyi.model.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends CrudRepository<Car, Long> {

    // создать 3 метода для фильтров (для всех сомбинаций)
    // и в каждый передавать объект Сорт

    List<Car> findByMarkLikeAndQualityClassLike(String mark, String qualityClass, Sort sort);

    List<Car> findByMarkContaining(String mark, Sort sort);

    List<Car> findByQualityClassContaining(String qualityClass, Sort sort);

    List<Car> findAll(Sort sort);
}

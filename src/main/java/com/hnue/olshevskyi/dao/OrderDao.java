package com.hnue.olshevskyi.dao;

import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {

    List<Order> findByUser(User user);

}

package com.hnue.olshevskyi.dao;

import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.OrderBill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBillDao extends CrudRepository<OrderBill, Long> {

    List<OrderBill> findByOrder(Order order);
}

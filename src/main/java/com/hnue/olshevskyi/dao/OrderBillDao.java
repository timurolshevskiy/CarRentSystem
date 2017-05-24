package com.hnue.olshevskyi.dao;

import com.hnue.olshevskyi.model.OrderBill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBillDao extends CrudRepository<OrderBill, Long> {
}

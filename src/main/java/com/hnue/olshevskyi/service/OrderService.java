package com.hnue.olshevskyi.service;

import com.hnue.olshevskyi.dao.OrderBillDao;
import com.hnue.olshevskyi.dao.OrderDao;
import com.hnue.olshevskyi.dto.OrderDto;
import com.hnue.olshevskyi.model.Order;
import com.hnue.olshevskyi.model.OrderBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderBillDao orderBillDao;

    @Autowired
    private CarService carService;

    public Order makeOrder(OrderDto orderDto) {
        return orderDao.save(new Order(0, orderDto.getDescription(), orderDto.getTermDays(), orderDto.isWithDriver(),
                "Created", orderDto.getPassportSeries(), orderDto.getPassportNumber(), orderDto.getUser(),
                carService.getCarById(orderDto.getCarId())));
    }

    private OrderBill createBill(Order order) {
        return orderBillDao.save(new OrderBill(0, "", order, order.getTermDays() * order.getCar().getPricePerDay(), false));
    }

    public OrderBill payForBill(long id) {
        OrderBill bill = orderBillDao.findOne(id);
        bill.setPaid(true);
        return orderBillDao.save(bill);
    }

    public OrderBill confirmOrder(long id) {
        Order order = orderDao.findOne(id);
        order.setStatus("In progress");
        order.getCar().setAvailable(false);
        orderDao.save(order);
        return createBill(order);
    }

    public Order completeOrder(long id) {
        Order order = orderDao.findOne(id);
        order.setStatus("Completed");
        return orderDao.save(order);
    }

    public OrderBill billForDamages(long orderId, double cost) {
        Order order = orderDao.findOne(orderId);
        return orderBillDao.save(new OrderBill(0, "", order, cost, false));
    }

    public Order cancelOrder(long id, String reason) {
        Order order = orderDao.findOne(id);
        order.setStatus("Cancelled");
        order.setDescription(reason);
        return orderDao.save(order);
    }

    public Order findOrderById(long id) {
        return orderDao.findOne(id);
    }

    public List<OrderBill> findBillsForOrder(Order order) {
        return orderBillDao.findByOrder(order);
    }

}

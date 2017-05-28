package com.hnue.olshevskyi.listener;

import com.hnue.olshevskyi.dao.*;
import com.hnue.olshevskyi.dto.OrderDto;
import com.hnue.olshevskyi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CarDao carDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderBillDao orderBillDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Role client = roleDao.save(new Role(0, "CLIENT"));
        Role manager = roleDao.save(new Role(0, "MANAGER"));
        Role admin = roleDao.save(new Role(0, "ADMIN"));

        userDao.save(new User(0, "admin", "admin", "admin", "admin", "admin", admin, false));
        userDao.save(new User(0, "manager", "manager", "manager", "manager", "manager", manager, false));
        User clientUser = userDao.save(new User(0, "client", "client", "client", "client", "client", client, false));

        Car car = carDao.save(new Car(0, "A6" + 0,
                "Good car for travelling. Max speed = 200 km/h. Suites for serious people",
                "High" + 0, "Audi" + 0, 15.3 + 10 - 0, true));
        for (int i = 1; i < 5; i++) {
            carDao.save(new Car(0, "A6" + i,
                    "Good car for travelling. Max speed = 200 km/h. Suites for serious people",
                    "High" + i, "Audi" + i, 15.3 + 10 - i, true));
        }

        Order order = orderDao.save(new Order(0, "qqq", 2, false, "In progress",
                "re", "11", LocalDate.now(), clientUser, car));
        orderBillDao.save(new OrderBill(0, "www", order, 150, false));
        orderBillDao.save(new OrderBill(0, "www", order, 150, false));
    }
}

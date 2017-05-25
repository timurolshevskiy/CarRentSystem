package com.hnue.olshevskyi.listener;

import com.hnue.olshevskyi.dao.CarDao;
import com.hnue.olshevskyi.dao.RoleDao;
import com.hnue.olshevskyi.dao.UserDao;
import com.hnue.olshevskyi.model.Car;
import com.hnue.olshevskyi.model.Role;
import com.hnue.olshevskyi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CarDao carDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Role client = roleDao.save(new Role(0, "CLIENT"));
        Role manager = roleDao.save(new Role(0, "MANAGER"));
        Role admin = roleDao.save(new Role(0, "ADMIN"));

        userDao.save(new User(0, "admin", "admin", "admin", "admin", "admin", admin, false));
        userDao.save(new User(0, "manager", "manager", "manager", "manager", "manager", manager, false));
        userDao.save(new User(0, "client", "client", "client", "client", "client", client, false));

        carDao.save(new Car(0, "A6", "High", "Audi", 15.3, true));
        carDao.save(new Car(0, "A6", "High", "Audi", 15.3, true));
        carDao.save(new Car(0, "A6", "High", "Audi", 15.3, true));
        carDao.save(new Car(0, "A6", "High", "Audi", 15.3, true));
        carDao.save(new Car(0, "A6", "High", "Audi", 15.3, true));
    }
}

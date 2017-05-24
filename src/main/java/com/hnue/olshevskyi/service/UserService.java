package com.hnue.olshevskyi.service;

import com.hnue.olshevskyi.dao.RoleDao;
import com.hnue.olshevskyi.dao.UserDao;
import com.hnue.olshevskyi.dto.UserRegistrationDto;
import com.hnue.olshevskyi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerUser(UserRegistrationDto userRegistrationDto) {
        return userDao.save(new User(0, userRegistrationDto.getLogin(), userRegistrationDto.getPassword(),
                userRegistrationDto.getEmail(), userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                roleDao.findByRole("CLIENT"), false));
    }

    public User registerMannager(UserRegistrationDto userRegistrationDto) {
        return userDao.save(new User(0, userRegistrationDto.getLogin(), userRegistrationDto.getPassword(),
                userRegistrationDto.getEmail(), userRegistrationDto.getFirstName(), userRegistrationDto.getLastName(),
                roleDao.findByRole("MANAGER"), false));
    }

}

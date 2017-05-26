package com.hnue.olshevskyi.service;

import com.hnue.olshevskyi.dao.RoleDao;
import com.hnue.olshevskyi.dao.UserDao;
import com.hnue.olshevskyi.dto.UserRegistrationDto;
import com.hnue.olshevskyi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User findUserById(long id) {
        return userDao.findOne(id);
    }

    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }

    public void changeBlocked(long id, boolean blocked) {
        User user = findUserById(id);
        user.setBlocked(blocked);
        userDao.save(user);
    }

}

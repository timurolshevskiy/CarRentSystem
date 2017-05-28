package com.hnue.olshevskyi.dao;

import com.hnue.olshevskyi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {

    User findByLogin(String login);

}

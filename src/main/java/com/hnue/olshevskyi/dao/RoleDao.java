package com.hnue.olshevskyi.dao;

import com.hnue.olshevskyi.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

    Role findByRole(String role);

}

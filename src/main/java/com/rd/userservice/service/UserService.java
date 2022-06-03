package com.rd.userservice.service;

import com.rd.userservice.domain.Role;
import com.rd.userservice.domain.User;

import java.util.List;

/**
 * Created at 2.06.2022.
 *
 * @author Ridvan Dogan
 */
public interface UserService {
    User saveUser(User user);
    Role saveRole (Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}

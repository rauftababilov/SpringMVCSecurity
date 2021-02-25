package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> listUsers();
    void removeUser(Long id);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByName(String name);
    List<Role> getAllRoles();
}

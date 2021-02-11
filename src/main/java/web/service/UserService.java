package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void addUser(User user);
    List<User> listUsers();
    void removeUser(Long id);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByName(String name);
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}

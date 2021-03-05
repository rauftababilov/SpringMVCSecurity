package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;


public interface UserService extends UserDetailsService {
    User findById(Long id);

    List<User> findAll();

    User findByName(String name);

    void saveUser(User user);

    void editUser(User user);

    void deleteById(Long id);

    Set<Role> findAllRoles();
}

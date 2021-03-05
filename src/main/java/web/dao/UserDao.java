package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);

    List<User> findAll();

    User findByName(String name);

    void saveUser(User user);

    void editUser(User user);

    void deleteById(Long id);

}

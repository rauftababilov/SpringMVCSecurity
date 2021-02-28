package web.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }


    @Transactional
    @Override
    public List<User> findAll() {
        return entityManager
                .createQuery("from User")
                .getResultList();
    }

    @Transactional
    @Override
    public User findByName(String name) {
        return (User) entityManager.createQuery("select user from User user where user.name=:name")
                .setParameter("name", name)
                .getSingleResult();
    }
}

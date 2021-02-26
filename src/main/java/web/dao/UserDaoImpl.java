package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        getEntityManager().persist(user);
    }

    @Transactional
    @Override
    public void editUser(User user) {
        getEntityManager().merge(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        getEntityManager().createQuery("delete from User where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return getEntityManager().find(User.class, id);
    }


    @Transactional
    @Override
    public List<User> findAll() {
        return getEntityManager()
                .createQuery("from User")
                .getResultList();
    }

    @Transactional
    @Override
    public User findByName(String name) {
        return (User) getEntityManager().createQuery("select user from User user where user.name=:name")
                .setParameter("name", name)
                .getSingleResult();
    }
}

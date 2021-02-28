package web.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@AllArgsConstructor
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    //    @Transactional
//    @Override
//    public void createRole(Set<Role> roles) {
//        roles.forEach(role -> entityManager.persist(role));
//    }

    @Transactional
    @Override
    public Set<Role> findAllRoles() {
        Set<Role> roleSet = new HashSet();
        List<Role> roleList = entityManager.createQuery("select role from Role role").getResultList();
        roleSet.addAll(roleList);
        return roleSet;
    }
}

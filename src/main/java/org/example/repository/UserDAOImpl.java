package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.entity.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public List<User> getUsers(){
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}

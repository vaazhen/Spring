package org.example.service;

import org.example.entity.User;
import org.example.repository.UserDAO;
import org.example.repository.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    @Transactional
    @Override
    public List<User> getUsers(){
        return userDAO.getUsers();
    }
    @Transactional
    @Override

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
    @Transactional
    @Override

    public User getUser(int id) {
        return userDAO.getUser(id);
    }
    @Transactional
    @Override

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}

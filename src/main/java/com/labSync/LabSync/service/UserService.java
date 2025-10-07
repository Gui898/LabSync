package com.labSync.LabSync.service;

import com.labSync.LabSync.models.User;
import com.labSync.LabSync.persistence.DAOS.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User addUser(User user) {
        userDAO.add(user);
        return user;
    }

    public User updateUser(User user) {
        userDAO.edit(user);
        return user;
    }

    public long delete(long id){
        userDAO.delete(id);
        return id;
    }

    public User getUserById(int id) {
        return userDAO.findById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

}

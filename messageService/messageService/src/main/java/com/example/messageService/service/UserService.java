package com.example.messageService.service;

import com.example.messageService.dao.UserDao;
import com.example.messageService.model.Password;
import com.example.messageService.model.User;
import com.example.messageService.utils.UserThrowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    public User selectUserByID(UUID id) {
        return userDao.selectUserByID(id).orElse(null);
    }

    public User updateUserByID(UUID id, User user) {
        return userDao.updateUserByID(id, user);
    }
}

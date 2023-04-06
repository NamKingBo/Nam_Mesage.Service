package com.example.messageService.dao;

import com.example.messageService.model.Password;
import com.example.messageService.model.User;
import com.example.messageService.utils.UserThrowException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int insertUser(UUID id, User user);

    Optional<User> selectUserByID(UUID id);

    User updateUserByID(UUID id, User user);

    List<User> selectAllUser();
}

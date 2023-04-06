package com.example.messageService.dao;

import com.example.messageService.model.User;
import com.example.messageService.usecase.UserRepository;
import com.example.messageService.utils.UserThrowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("userDao")
public class UserDataAccessService implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository userRepository;

    public List<User> DBUser = new ArrayList<>();
    @Override
    public int insertUser(UUID id, User user) {
        String sqlQuery = "INSERT INTO users(uid, name, email, username, note) VALUES ("
                + "'"+ id +"','"+ user.getName() +"','" + user.getEmail() + "','" + user.getUsername()+"','" +user.getNote() +"')";
        jdbcTemplate.update(sqlQuery);
        return 1;
    }

    @Override
    public Optional<User> selectUserByID(UUID id) {
        DBUser = userRepository.findAll();

        return DBUser.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public User updateUserByID(UUID id, User user) {
        User userUpdate = selectUserByID(id).orElse(null);
        if (userUpdate != null) {
            mapperUser(userUpdate, user);
            userRepository.save(userUpdate);
        }
        return userUpdate;
    }

    @Override
    public List<User> selectAllUser() {
        DBUser = userRepository.findAll();
        return DBUser;
    }

    private void mapperUser(User user1, User user2) {
        user1.setName((user2.getName().isBlank() || user2.getName() == null) ? user1.getName() : user2.getName());
        user1.setEmail((user2.getEmail().isBlank() || user2.getEmail() == null) ? user1.getEmail() : user2.getEmail());
        user1.setUsername((user2.getUsername().isBlank() || user2.getUsername() == null) ? user1.getUsername() : user2.getUsername());
        user1.setNote((user2.getNote().isBlank() || user2.getNote() == null) ? user1.getNote() : user2.getNote());
    }
}

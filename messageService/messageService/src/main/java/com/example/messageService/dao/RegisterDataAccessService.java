package com.example.messageService.dao;

import com.example.messageService.model.Password;
import com.example.messageService.model.Register;
import com.example.messageService.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("registerDao")
public class RegisterDataAccessService implements RegisterDao{
    private final UserDao userDao;
    private final PasswordDao passwordDao;

    public RegisterDataAccessService(@Qualifier("userDao") UserDao userDao,
                                     @Qualifier("passwordDao") PasswordDao passwordDao) {
        this.userDao = userDao;
        this.passwordDao = passwordDao;
    }

    @Override
    public Optional<User> registerUser(UUID id, Register register) {
        User user = new User();
        Password password = new Password();
        UUID newID = idNotSameID(id);

        password.setId(register.getId());
        password.setPassword(register.getPassword());
        user.setUsername(register.getUsername());
        user.setName(register.getFullName());
        user.setEmail(register.getEmail());
        user.setNote(register.getNote());

        if (!isSameUsername(register.getUsername())) {
            userDao.insertUser(newID, user);
            passwordDao.insertPassword(newID, password);
        }

        return userDao.selectUserByID(newID);
    }

    private UUID idNotSameID(UUID id) {
        UUID finalId = id;
        if (userDao.selectAllUser().stream().anyMatch(v -> v.getId().equals(finalId))) {
            id = UUID.randomUUID();
            return idNotSameID(id);
        }

        return finalId;
    }

    private boolean isSameUsername(String username) {
        return userDao.selectAllUser().parallelStream().anyMatch(v -> v.getUsername().equals(username));
    }
}

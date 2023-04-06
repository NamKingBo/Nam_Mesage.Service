package com.example.messageService.dao;

import com.example.messageService.model.LoginRequest;
import com.example.messageService.model.Password;
import com.example.messageService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("fakeLogin")
public class LoginDataAccessService implements LoginDao{
    private final UserDataAccessService userDataAccessService;
    private final PasswordDataAccessService passwordDataAccessService;

    @Autowired
    public LoginDataAccessService(UserDataAccessService userDataAccessService, PasswordDataAccessService passwordDataAccessService) {
        this.userDataAccessService = userDataAccessService;
        this.passwordDataAccessService = passwordDataAccessService;
    }

    @Override
    public User login(LoginRequest loginRequest) {
        for (User user: userDataAccessService.selectAllUser()) {
            for (Password password: passwordDataAccessService.selectAllPassword()) {
                if (loginRequest.getUsername().equals(user.getUsername())
                        && loginRequest.getPassword().equals(password.getPassword())
                        && user.getId().equals(password.getId())) {
                    return user;
                }
            }
        }

        return null;
    }
}

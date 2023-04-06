package com.example.messageService.service;

import com.example.messageService.dao.LoginDao;
import com.example.messageService.model.LoginRequest;
import com.example.messageService.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginDao loginDao;

    public LoginService(@Qualifier("fakeLogin") LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public User login(LoginRequest loginRequest) {
        return loginDao.login(loginRequest);
    }
}

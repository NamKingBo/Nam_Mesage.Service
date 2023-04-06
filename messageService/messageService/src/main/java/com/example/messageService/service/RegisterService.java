package com.example.messageService.service;

import com.example.messageService.dao.RegisterDao;
import com.example.messageService.dao.UserDao;
import com.example.messageService.model.Password;
import com.example.messageService.model.Register;
import com.example.messageService.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final RegisterDao registerDao;

    public RegisterService(@Qualifier("registerDao") RegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    public User registerUser(Register register) {
        return registerDao.registerUser(register).orElse(null);
    }
}

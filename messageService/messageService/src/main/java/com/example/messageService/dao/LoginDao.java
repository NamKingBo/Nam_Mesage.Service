package com.example.messageService.dao;

import com.example.messageService.model.LoginRequest;
import com.example.messageService.model.User;

public interface LoginDao {
    User login(LoginRequest loginRequest);
}

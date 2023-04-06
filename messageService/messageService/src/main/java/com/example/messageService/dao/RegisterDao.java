package com.example.messageService.dao;

import com.example.messageService.model.Password;
import com.example.messageService.model.Register;
import com.example.messageService.model.User;

import java.util.Optional;
import java.util.UUID;

public interface RegisterDao {
    Optional<User> registerUser(UUID id, Register register);

    default Optional<User> registerUser(Register register) {
        UUID id = UUID.randomUUID();
        return registerUser(id, register);
    }
}

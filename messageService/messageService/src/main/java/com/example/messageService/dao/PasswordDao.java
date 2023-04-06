package com.example.messageService.dao;

import com.example.messageService.model.Password;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PasswordDao {
    int insertPassword(UUID id, Password password);

    Optional<Password> selectPasswordByID(UUID id);
    Password updatePasswordByID(UUID id, Password password);

    List<Password> selectAllPassword();
}

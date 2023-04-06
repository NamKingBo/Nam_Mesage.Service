package com.example.messageService.service;

import com.example.messageService.dao.PasswordDao;
import com.example.messageService.model.Password;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordService {
    private final PasswordDao passwordDao;

    public PasswordService(@Qualifier("passwordDao") PasswordDao passwordDao) {
        this.passwordDao = passwordDao;
    }

    public List<Password> selectAllPassword() {
        return passwordDao.selectAllPassword();
    }

    public Password selectPasswordByID(UUID id) {
        return passwordDao.selectPasswordByID(id).orElse(null);
    }

    public Password updatePasswordByID(UUID id, Password password) {
        return passwordDao.updatePasswordByID(id, password);
    }
}

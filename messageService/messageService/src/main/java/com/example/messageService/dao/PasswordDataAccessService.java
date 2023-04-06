package com.example.messageService.dao;

import com.example.messageService.model.Password;
import com.example.messageService.usecase.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("passwordDao")
public class PasswordDataAccessService implements PasswordDao {
    private List<Password> DBPassword = new ArrayList<>();

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertPassword(UUID id, Password password) {
        String sqlQuery = "INSERT INTO passwords(id, password) VALUES('"
                + id + "','" + password.getPassword() + "')";
        jdbcTemplate.update(sqlQuery);
        return 1;
    }

    @Override
    public Optional<Password> selectPasswordByID(UUID id) {
        DBPassword = passwordRepository.findAll();
        return DBPassword.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public Password updatePasswordByID(UUID id, Password password) {
        Password passwordUpdate = selectPasswordByID(id).orElse(null);
        if (passwordUpdate != null) {
            mapperPassword(passwordUpdate, password);
            passwordRepository.save(passwordUpdate);
        }

        return passwordUpdate;
    }

    @Override
    public List<Password> selectAllPassword() {
        DBPassword = passwordRepository.findAll();
        return DBPassword;
    }

    private void mapperPassword(Password password1, Password password2) {
        password1.setPassword(password2.getPassword());
    }
}

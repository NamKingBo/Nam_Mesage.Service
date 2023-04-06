package com.example.messageService.api;

import com.example.messageService.constants.Constants;
import com.example.messageService.model.Password;
import com.example.messageService.service.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/password")
@RestController
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping
    public List<Password> selectAllPassword() {
        return passwordService.selectAllPassword();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> selectPasswordByID(@PathVariable("id") UUID id) {
        if (passwordService.selectPasswordByID(id) != null) {
            return new ResponseEntity<>(passwordService.selectPasswordByID(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(Constants.errorUser, HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updatePasswordByID(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Password password) {
        if (passwordService.updatePasswordByID(id, password) != null) {
            return new ResponseEntity<>(passwordService.updatePasswordByID(id, password), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Constants.errorUser, HttpStatus.BAD_REQUEST);
    }
}

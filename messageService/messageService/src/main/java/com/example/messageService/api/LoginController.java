package com.example.messageService.api;

import com.example.messageService.constants.Constants;
import com.example.messageService.model.LoginRequest;
import com.example.messageService.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/login")
@RestController
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if (loginService.login(loginRequest) != null) {
            return new ResponseEntity<>(loginService.login(loginRequest), HttpStatus.OK);
        }

        return new ResponseEntity<>(Constants.errorUser, HttpStatus.BAD_REQUEST);
    }
}

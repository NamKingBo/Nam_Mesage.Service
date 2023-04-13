package com.example.messageService.api;

import com.example.messageService.constants.Constants;
import com.example.messageService.model.Register;
import com.example.messageService.service.RegisterService;
import com.example.messageService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/register")
@RestController
public class RegisterController {
    private final RegisterService registerService;
    private final UserService userService;

    @Autowired
    public RegisterController(RegisterService registerService, UserService userService) {
        this.registerService = registerService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody Register register) {
        if (registerService.registerUser(register) != null) {
            return new ResponseEntity<>(registerService.registerUser(register), HttpStatus.OK);
        }

        return new ResponseEntity<>(Constants.errorRegister, HttpStatus.BAD_REQUEST);
    }
}

package com.example.messageService.api;

import com.example.messageService.constants.Constants;
import com.example.messageService.model.User;
import com.example.messageService.service.UserService;
import com.example.messageService.utils.UserThrowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> selectUserByID(@PathVariable("id") UUID id) {
        if (userService.selectUserByID(id) == null) {
            return new ResponseEntity<>("User is not existing", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.selectUserByID(id), HttpStatus.OK);
    }

    @GetMapping
    public List<User> selectAllUser() {
        return userService.selectAllUser();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateUserByID(@PathVariable("id") UUID id,@Validated @NonNull @RequestBody User user) {
        if (userService.selectUserByID(id) == null) {
            return new ResponseEntity<>(Constants.errorUser, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userService.updateUserByID(id, user), HttpStatus.OK) ;
    }
}

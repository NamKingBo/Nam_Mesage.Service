package com.example.messageService.api;

import com.example.messageService.constants.Constants;
import com.example.messageService.model.RoomChatSingle;
import com.example.messageService.service.RoomChatSingleService;
import com.example.messageService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(Constants.Url.requestRoom)
@RestController
public class RoomChatSingleController {
    private final RoomChatSingleService roomChatSingleService;
    private final UserService userService;

    @Autowired
    public RoomChatSingleController(RoomChatSingleService roomChatSingleService, UserService userService) {
        this.roomChatSingleService = roomChatSingleService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> insertRoom(@RequestBody RoomChatSingle room) {
        if (roomChatSingleService.insertRoom(room) == 0) {
            return new ResponseEntity<>("Room is all ready register!!!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Room can not be register!!!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getRoom(@PathVariable("id") UUID id) {
        if (userService.selectUserByID(id) != null) {
            return new ResponseEntity<>(roomChatSingleService.groupRoomById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>("User is not existing", HttpStatus.BAD_REQUEST);
    }
}

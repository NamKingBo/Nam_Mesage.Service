package com.example.messageService.service;

import com.example.messageService.dao.RoomChatSingleDao;
import com.example.messageService.model.OpenRoomResponse;
import com.example.messageService.model.RoomChatSingle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomChatSingleService {

    private final RoomChatSingleDao roomChatSingleDao;

    @Autowired
    public RoomChatSingleService(@Qualifier("roomSingleRoom") RoomChatSingleDao roomChatSingleDao) {
        this.roomChatSingleDao = roomChatSingleDao;
    }

    public List<RoomChatSingle> selectAllRoom() {
        return roomChatSingleDao.selectAllRoom();
    }

    public OpenRoomResponse insertRoom(RoomChatSingle room) {
        return roomChatSingleDao.insertRoom(room);
    }

    public List<RoomChatSingle> groupRoomById(UUID id) {
        return roomChatSingleDao.groupRoomById(id);
    }
}

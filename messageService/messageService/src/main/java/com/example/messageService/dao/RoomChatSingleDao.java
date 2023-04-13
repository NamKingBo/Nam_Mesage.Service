package com.example.messageService.dao;

import com.example.messageService.model.OpenRoomResponse;
import com.example.messageService.model.RoomChatSingle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoomChatSingleDao {
    OpenRoomResponse insertRoom(UUID id, RoomChatSingle room);

    default OpenRoomResponse insertRoom(RoomChatSingle room) {
        UUID id = UUID.randomUUID();
        return insertRoom(id, room);
    }

    List<RoomChatSingle> groupRoomById(UUID id);

    List<RoomChatSingle> selectAllRoom();
}

package com.example.messageService.dao;

import com.example.messageService.model.OpenRoomResponse;
import com.example.messageService.model.RoomChatSingle;
import com.example.messageService.usecase.RoomChatSingleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("roomSingleDao")
public class RoomChatSingleDataAccessService implements RoomChatSingleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RoomChatSingleRepository roomChatSingleRepository;

    private List<RoomChatSingle> DBRoom = new ArrayList<>();

    @Override
    public OpenRoomResponse insertRoom(UUID id, RoomChatSingle room) {
        if (isSameRoomId(id)) {
            RoomChatSingle room = sel
            return new OpenRoomResponse(id, );
        }
        if (!isSameRoomCode(room.getCode())) {
            String sqlQuery = "INSERT INTO roomsSingle(uid, code, name, lastMessage, updateAt, alias) VALUES ('"
                    + newId + "','" + room.getName() + "','" + room.getCode() + "','" + room.getLastMessage() + "','" + room.getUpdateAt() + "','" + room.getAlias() + "')";
            jdbcTemplate.update(sqlQuery);

            return 0;
        }

        return 1;
    }

    @Override
    public List<RoomChatSingle> groupRoomById(UUID id) {
        DBRoom = roomChatSingleRepository.findAll();
        return DBRoom.stream()
                .filter(v -> userInRoom(v.getName(), String.valueOf(id)))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomChatSingle> selectAllRoom() {
        DBRoom = roomChatSingleRepository.findAll();
        return DBRoom;
    }

    private boolean userInRoom(String codeRoom, String id) {
        String[] str = codeRoom.split("-");

        for (String userId: str) {
            if (userId.equals(id)) return true;
        }

        return false;
    }

    private boolean isSameRoomId(UUID id) {
        return selectAllRoom().stream().anyMatch(v -> v.getId().equals(id));
    }

    private boolean isSameRoomCode(String codeRoom) {
        return selectAllRoom().stream().anyMatch(v -> v.getCode().equals(codeRoom));
    }
}

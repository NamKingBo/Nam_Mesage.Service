package com.example.messageService.dao;

import com.example.messageService.model.Message;

import java.util.List;
import java.util.UUID;

public interface MessageDao {
    void insert(UUID id, Message message);

    default void insert(Message message) {
        UUID id = UUID.randomUUID();
        insert(id, message);
    }

    List<Message> selectMessageByUserID(UUID uid);
}

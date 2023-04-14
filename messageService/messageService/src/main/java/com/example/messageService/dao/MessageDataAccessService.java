package com.example.messageService.dao;

import com.example.messageService.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageDataAccessService implements MessageDao{

    List<Message> DBMessage = new ArrayList<>();

    @Override
    public void insert(UUID id, Message message) {
        
    }

    @Override
    public List<Message> selectMessageByUserID(UUID uid) {
        return null;
    }
}

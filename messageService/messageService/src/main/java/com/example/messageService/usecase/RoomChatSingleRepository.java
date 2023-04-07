package com.example.messageService.usecase;

import com.example.messageService.model.RoomChatSingle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomChatSingleRepository extends JpaRepository<RoomChatSingle, Integer> {
}

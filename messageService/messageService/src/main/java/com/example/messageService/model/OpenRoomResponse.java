package com.example.messageService.model;

import java.util.UUID;

public class OpenRoomResponse {
    private final UUID id;
    private final String code;
    private final String name;
    private final String alias;

    public OpenRoomResponse(UUID id, String code, String name, String alias) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.alias = alias;
    }
}

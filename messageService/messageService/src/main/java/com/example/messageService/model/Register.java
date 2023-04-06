package com.example.messageService.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Register {
    private final UUID id;
    private final String username;
    private final String fullName;
    private final String email;
    private final String note;
    private final String password;

    public Register(@JsonProperty("id") UUID id,
                    @JsonProperty("username") String username,
                    @JsonProperty("fullName") String fullName,
                    @JsonProperty("email")String email,
                    @JsonProperty("note") String note,
                    @JsonProperty("password") String password) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.note = note;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getNote() {
        return note;
    }

    public String getPassword() {
        return password;
    }
}

package com.example.messageService.model;

import java.util.Date;
import java.util.UUID;

public class Message {
    private UUID id;
    private String channel_id;
    private UUID sender_id;
    private UUID receiver_id;
    private String sender_code;
    private String receiver_code;
    private String message;
    private boolean is_modified;
    private Date modified_date;
    private boolean is_deleted = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public UUID getSender_id() {
        return sender_id;
    }

    public void setSender_id(UUID sender_id) {
        this.sender_id = sender_id;
    }

    public UUID getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(UUID receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getSender_code() {
        return sender_code;
    }

    public void setSender_code(String sender_code) {
        this.sender_code = sender_code;
    }

    public String getReceiver_code() {
        return receiver_code;
    }

    public void setReceiver_code(String receiver_code) {
        this.receiver_code = receiver_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIs_modified() {
        return is_modified;
    }

    public void setIs_modified(boolean is_modified) {
        this.is_modified = is_modified;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}

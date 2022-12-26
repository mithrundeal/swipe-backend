package com.mithrundeal.swipebackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterRequest {
    @JsonProperty("uuid")
    String uuid;
    @JsonProperty("username")
    String username;
    @JsonProperty("password")
    String password;
    @JsonProperty("email")
    String email;

    public RegisterRequest(String uuid, String username, String password, String email) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public RegisterRequest() {
    }
}

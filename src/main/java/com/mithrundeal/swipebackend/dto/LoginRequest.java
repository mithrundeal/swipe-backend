package com.mithrundeal.swipebackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;


/**
 * here you are
 *
 * @apiNote apinote
 * @implNote {@link LoginResponse}
 */
@Data
@ToString
public class LoginRequest {
    @JsonProperty("username")
    String username;
    @JsonProperty("password")
    String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

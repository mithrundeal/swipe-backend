package com.mithrundeal.swipebackend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class LoginResponse extends BaseResponseBody {
    String username;
    String password;

    public LoginResponse() {
    }

    public LoginResponse(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

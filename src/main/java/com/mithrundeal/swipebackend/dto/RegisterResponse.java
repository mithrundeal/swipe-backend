package com.mithrundeal.swipebackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class RegisterResponse extends BaseResponseBody {

    @JsonProperty("user")
    User user;
}

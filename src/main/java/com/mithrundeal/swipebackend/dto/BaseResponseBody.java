package com.mithrundeal.swipebackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseResponseBody {
    @JsonProperty("uuid")
    String uuid;
    @JsonProperty("isSuccessful")
    Boolean isSuccessful;

    @JsonProperty("errorMessage")
    String errorMessage;
}

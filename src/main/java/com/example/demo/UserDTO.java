package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {

    private Integer id;

    private String name;

    private Integer age;

    private Boolean active;

    private String activeDesc;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}

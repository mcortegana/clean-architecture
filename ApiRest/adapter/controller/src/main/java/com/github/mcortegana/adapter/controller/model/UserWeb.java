package com.github.mcortegana.adapter.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWeb {

    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

}

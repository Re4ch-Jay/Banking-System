package com.reach.banking.dto;

import java.util.Date;

import lombok.Data;

@Data
public class RegisterDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date date;
}

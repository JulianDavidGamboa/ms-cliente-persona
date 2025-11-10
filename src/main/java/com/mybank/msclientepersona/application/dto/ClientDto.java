package com.mybank.msclientepersona.application.dto;

import lombok.Data;

@Data
public class ClientDto {
    private String clientId;
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
    private String password;
    private boolean active;
}

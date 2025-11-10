package com.mybank.msclientepersona.infrastructure.adapter.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ClientEntity {
    @Id
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
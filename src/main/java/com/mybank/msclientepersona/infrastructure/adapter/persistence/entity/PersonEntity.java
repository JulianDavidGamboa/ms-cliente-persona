package com.mybank.msclientepersona.infrastructure.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class PersonEntity {
    private String name;
    private String gender;
    private Integer age;

    @Column(unique = true, nullable = false)
    private String id;

    private String address;
    private String phoneNumber;
}

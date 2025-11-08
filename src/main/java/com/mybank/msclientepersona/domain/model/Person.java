package com.mybank.msclientepersona.domain.model;

public class Person {

    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String phone_number;

    public Person(String name, String gender, int age, Long id, String address, String phone_number) {
        this.validarDatos(name, id);
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
        this.address = address;
        this.phone_number = phone_number;
    }

    public void validarDatos(String name, Long id) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del persona es obligatorio");
        }
        if (id == null) {
            throw new IllegalArgumentException("El id del persona es obligatorio");
        }
    }

    public void actualizarDatos(String name, String gender, Integer age,
                                String address, String phoneNumber) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phone_number = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}

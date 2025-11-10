package com.mybank.msclientepersona.domain.model;

public class Client extends Person {
    private String clientId;
    private String password;
    private boolean active;

    public Client() {}

    public Client(String name, String gender, int age, String identification, String address, String phone, String clientId, String password, boolean active) {
        super(name, gender, age, identification, address, phone);
        this.clientId = clientId;
        this.password = password;
        this.active = active;
    }

    // Getters and setters
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

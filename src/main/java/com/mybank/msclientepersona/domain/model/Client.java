package com.mybank.msclientepersona.domain.model;

import java.util.UUID;

public class Client extends Person {

    private String clientId;
    private String password;
    private Boolean status;

    public Client(String clientId, String password, Boolean status, String name, String gender, int age, Long id, String address, String phone_number) {
        super(name, gender, age, id, address, phone_number);
        this.validateData(clientId, password);
        this.clientId = clientId;
        this.password = password;
        this.status = status;
    }

    private void validateData(String clienteId, String password) {
        if (clienteId == null || clienteId.trim().isEmpty()) {
            throw new IllegalArgumentException("El clienteId no puede estar vacío");
        }
        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 4 caracteres");
        }
    }

    public String getClientId() {
        return clientId;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean isActive() { return this.status != null && this.status; }
}

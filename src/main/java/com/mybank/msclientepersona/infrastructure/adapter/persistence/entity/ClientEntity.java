package com.mybank.msclientepersona.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "clientes")
@Getter @Setter
public class ClientEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID clienteId;

    private String contrasena;
    private Boolean estado;
}

package com.mybank.msclientepersona.domain.repository;

import com.mybank.msclientepersona.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    Client save(Client client);
    Optional<Client> findById(Long id);
    Optional<Client> findByClientId(String clienteId);
    void deleteById(Long id);
    boolean existsByClienteId(String clienteId);
    boolean existsByIdentificacion(Long identificacion);
}

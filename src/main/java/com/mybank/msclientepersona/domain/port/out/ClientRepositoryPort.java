package com.mybank.msclientepersona.domain.port.out;

import com.mybank.msclientepersona.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> findById(String id);
    List<Client> findAll();
    void deleteById(String id);
}

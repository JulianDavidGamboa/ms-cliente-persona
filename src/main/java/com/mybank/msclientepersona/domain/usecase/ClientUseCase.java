package com.mybank.msclientepersona.domain.usecase;

import com.mybank.msclientepersona.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientUseCase {
    Client create(Client client);
    Client update(Client client);
    void deleteById(String id);
    Optional<Client> findById(String id);
    List<Client> findAll();
}
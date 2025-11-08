package com.mybank.msclientepersona.domain.service;

import com.mybank.msclientepersona.domain.exception.ClientException;
import com.mybank.msclientepersona.domain.model.Client;
import com.mybank.msclientepersona.domain.repository.ClientRepository;

public class ClientDomainService {

    private final ClientRepository clientRepository;

    public ClientDomainService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(String clientId, String password, String name, String gender, Integer age, Long id, String address, String phoneNumber) {

        if (clientRepository.existsByClienteId(clientId)) {
            throw new IllegalArgumentException("El cliente ya existe");
        }

        if (clientRepository.existsByIdentificacion(id)) {
            throw new IllegalArgumentException("Ya existe un cliente con la identificacion");
        }

        Client client = new Client(clientId, password, true, name, gender, age, id, address, phoneNumber);

        return clientRepository.save(client);

    }

    public void validateActiveClient(Client client) {
        if (!client.isActive()) {
            throw new ClientException("El cliente no está activo");
        }
    }
}

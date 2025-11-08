package com.mybank.msclientepersona.application.service;

import com.mybank.msclientepersona.domain.model.Client;
import com.mybank.msclientepersona.domain.port.in.ClientUseCase;
import com.mybank.msclientepersona.domain.port.out.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientUseCase {

    private final ClientRepositoryPort repositoryPort;

    @Override
    public Client create(Client client) {
        return repositoryPort.create(client);
    }

    @Override
    public Optional<Client> read(UUID id) {
        return repositoryPort.read(id);
    }

    @Override
    public Client update(UUID clientId, Client client) {
        return repositoryPort.update(clientId, client);
    }

    @Override
    public void delete(UUID clientId) {
        repositoryPort.delete(clientId);
    }
}

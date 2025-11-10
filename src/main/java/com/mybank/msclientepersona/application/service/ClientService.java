package com.mybank.msclientepersona.application.service;

import com.mybank.msclientepersona.domain.event.ClientEvent;
import com.mybank.msclientepersona.domain.event.ClientEventDto;
import com.mybank.msclientepersona.domain.model.Client;
import com.mybank.msclientepersona.domain.port.out.ClientRepositoryPort;
import com.mybank.msclientepersona.domain.usecase.ClientUseCase;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService implements ClientUseCase {

    private final ClientRepositoryPort repositoryPort;
    private final KafkaTemplate<String, ClientEventDto> kafkaTemplate;

    public ClientService(ClientRepositoryPort repositoryPort, KafkaTemplate<String, ClientEventDto> kafkaTemplate) {
        this.repositoryPort = repositoryPort;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Client create(Client client) {
        client.setClientId(UUID.randomUUID().toString());
        Client saved = repositoryPort.save(client);
        publishEvent("CREATED", saved);
        return saved;
    }

    @Override
    public Client update(Client client) {
        Client saved = repositoryPort.save(client);
        publishEvent("UPDATED", saved);
        return saved;
    }

    @Override
    public void deleteById(String id) {
        Optional<Client> optionalClient = repositoryPort.findById(id);
        if (optionalClient.isPresent()) {
            publishEvent("DELETED", optionalClient.get());
        }
        repositoryPort.deleteById(id);
    }

    @Override
    public Optional<Client> findById(String id) {
        return repositoryPort.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return repositoryPort.findAll();
    }

    private void publishEvent(String type, Client client) {
        kafkaTemplate.send("client-events",
                new ClientEventDto(
                        UUID.randomUUID().toString(),
                        "CREATED",
                        client.getClientId(),
                        client.getName()
                )
        );
    }
}

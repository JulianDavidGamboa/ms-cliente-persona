package com.mybank.msclientepersona.infrastructure.adapter;

import com.mybank.msclientepersona.application.mapper.ClientMapper;
import com.mybank.msclientepersona.domain.model.Client;
import com.mybank.msclientepersona.domain.port.out.ClientRepositoryPort;
import com.mybank.msclientepersona.infrastructure.adapter.jpa.entity.ClientEntity;
import com.mybank.msclientepersona.infrastructure.adapter.jpa.repository.ClientJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClientRepositoryAdapter implements ClientRepositoryPort {
    private final ClientJpaRepository jpaRepository;
    private final ClientMapper mapper;

    public ClientRepositoryAdapter(ClientJpaRepository jpaRepository, ClientMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Client save(Client client) {
        ClientEntity entity = mapper.toEntity(client);
        ClientEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Client> findById(String id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        jpaRepository.deleteById(id);
    }
}
package com.mybank.msclientepersona.application.mapper;

import com.mybank.msclientepersona.application.dto.ClientDto;
import com.mybank.msclientepersona.domain.model.Client;
import com.mybank.msclientepersona.infrastructure.adapter.jpa.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toDomain(ClientDto dto) {
        Client client = new Client();
        client.setClientId(dto.getClientId());
        client.setName(dto.getName());
        client.setGender(dto.getGender());
        client.setAge(dto.getAge());
        client.setIdentification(dto.getIdentification());
        client.setAddress(dto.getAddress());
        client.setPhone(dto.getPhone());
        client.setPassword(dto.getPassword());
        client.setActive(dto.isActive());
        return client;
    }

    public ClientDto toDto(Client domain) {
        ClientDto dto = new ClientDto();
        dto.setClientId(domain.getClientId());
        dto.setName(domain.getName());
        dto.setGender(domain.getGender());
        dto.setAge(domain.getAge());
        dto.setIdentification(domain.getIdentification());
        dto.setAddress(domain.getAddress());
        dto.setPhone(domain.getPhone());
        dto.setPassword(domain.getPassword());
        dto.setActive(domain.isActive());
        return dto;
    }

    public ClientEntity toEntity(Client domain) {
        ClientEntity entity = new ClientEntity();
        entity.setClientId(domain.getClientId());
        entity.setName(domain.getName());
        entity.setGender(domain.getGender());
        entity.setAge(domain.getAge());
        entity.setIdentification(domain.getIdentification());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setPassword(domain.getPassword());
        entity.setActive(domain.isActive());
        return entity;
    }

    public Client toDomain(ClientEntity entity) {
        Client client = new Client();
        client.setClientId(entity.getClientId());
        client.setName(entity.getName());
        client.setGender(entity.getGender());
        client.setAge(entity.getAge());
        client.setIdentification(entity.getIdentification());
        client.setAddress(entity.getAddress());
        client.setPhone(entity.getPhone());
        client.setPassword(entity.getPassword());
        client.setActive(entity.isActive());
        return client;
    }

}

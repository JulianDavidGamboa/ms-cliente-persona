package com.mybank.msclientepersona.application.mapper;

import com.mybank.msclientepersona.application.dto.ClientDto;
import com.mybank.msclientepersona.domain.model.Client;
import com.mybank.msclientepersona.infrastructure.adapter.jpa.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toDomain(ClientEntity entity);
    ClientEntity toEntity(Client domain);
    ClientDto toDto(Client domain);
    Client toDomain(ClientDto dto);
}
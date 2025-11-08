package com.mybank.msclientepersona.infrastructure.adapter.persistence.repository;

import com.mybank.msclientepersona.infrastructure.adapter.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, UUID> {
}

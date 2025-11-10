package com.mybank.msclientepersona.infrastructure.adapter.jpa.repository;

import com.mybank.msclientepersona.infrastructure.adapter.jpa.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, String> {
}

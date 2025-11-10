package com.mybank.msclientepersona.application.rest;

import com.mybank.msclientepersona.application.dto.ClientDto;
import com.mybank.msclientepersona.application.mapper.ClientMapper;
import com.mybank.msclientepersona.application.service.ClientService;
import com.mybank.msclientepersona.domain.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;
    private final ClientMapper mapper;

    public ClientController(ClientService service, ClientMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ClientDto create(@RequestBody ClientDto dto) {
        Client domain = mapper.toDomain(dto);
        Client saved = service.create(domain);
        return mapper.toDto(saved);
    }

    @PutMapping("/{id}")
    public ClientDto update(@PathVariable String id, @RequestBody ClientDto dto) {
        Client domain = mapper.toDomain(dto);
        domain.setClientId(id);
        Client updated = service.update(domain);
        return mapper.toDto(updated);
    }

    @GetMapping
    public List<ClientDto> findAll() {
        return service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable String id) {
        return service.findById(id)
                .map(client -> ResponseEntity.ok(mapper.toDto(client)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}

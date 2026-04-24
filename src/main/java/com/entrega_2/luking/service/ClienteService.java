package com.entrega_2.luking.service;

import com.entrega_2.luking.dto.ClienteRequestDTO;
import com.entrega_2.luking.dto.ClienteResponseDTO;
import com.entrega_2.luking.model.Cliente;
import com.entrega_2.luking.repository.ClienteRepository;

public class ClienteService {
    
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteResponseDTO guardar(ClienteRequestDTO dto) {

        if (dto.getemail() == null || dto.getemail().isEmpty()) {
            throw new ClienteException("El correo es obligatorio");
        }

        // Evitar correos duplicados
        repository.findByCorreo(dto.getemail())
                .ifPresent(c -> {
                    throw new ClienteException("El correo ya está registrado");
                });

        Cliente cliente = mapper.toEntity(dto);
        Cliente guardado = repository.save(cliente);

        return mapper.toDTO(guardado);
    }

    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ClienteException("Cliente no encontrado"));
        return mapper.toDTO(cliente);  
    }
}

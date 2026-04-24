package com.entrega_2.luking.mapper;

import org.mapstruct.Mapper;

import com.entrega_2.luking.dto.ClienteRequestDTO;
import com.entrega_2.luking.dto.ClienteResponseDTO;
import com.entrega_2.luking.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toDTO(Cliente cliente);
}

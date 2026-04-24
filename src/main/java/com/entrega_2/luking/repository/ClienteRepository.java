package com.entrega_2.luking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entrega_2.luking.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}

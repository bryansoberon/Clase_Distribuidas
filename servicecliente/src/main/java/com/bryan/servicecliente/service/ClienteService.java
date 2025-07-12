package com.bryan.servicecliente.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.bryan.servicecliente.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll(Pageable page);
    Cliente getById(int id);
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(int id);
}

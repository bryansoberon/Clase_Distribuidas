package com.bryan.servicecliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bryan.servicecliente.entity.Cliente;
import com.bryan.servicecliente.repository.ClienteRepository;
import com.bryan.servicecliente.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll(Pageable page) {
        return repository.findAll(page).getContent();
    }

    @Override
    public Cliente getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        if (repository.existsById(cliente.getId())) {
            return repository.save(cliente);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}

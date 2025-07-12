package com.bryan.serviceproducto.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bryan.serviceproducto.entity.Producto;
import com.bryan.serviceproducto.repository.ProductoRepository;
import com.bryan.serviceproducto.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private ProductoRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> getAll(Pageable page) {
		try {
			List<Producto> registros=repository.findAll(page).toList();
			return registros;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Producto getById(int id) {
		try {
			Producto registro=repository.findById(id).orElseThrow();
			return registro;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public Producto create(Producto producto) {
		try {
			Producto registro=repository.save(producto);
			return registro;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public Producto update(Producto producto) {
		try {
			Producto registro= repository.findById(producto.getId()).orElseThrow();
			registro.setNombre(producto.getNombre());
			registro.setStock(producto.getStock());
			registro.setDescripcion(producto.getDescripcion());
			repository.save(registro);
			return registro;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}
}


package com.bryan.serviceproducto.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bryan.serviceproducto.service.ProductoService;
import com.bryan.serviceproducto.entity.Producto;
@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAll(
			@RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
			){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		List<Producto> registros = service.getAll(page);
		return ResponseEntity.ok(registros);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Producto> getById(@PathVariable("id") int id){
		Producto producto = service.getById(id);
		if(producto==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}
	
	@PostMapping 	
	public ResponseEntity<Producto> create(@RequestBody Producto producto){
		Producto registro = service.create(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(registro);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Producto> update(@PathVariable("id") int id,@RequestBody Producto producto){
		producto.setId(id);
		Producto registro=service.update(producto);
		if(registro==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(registro);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Producto> delete(@PathVariable("id") int id){
		service.delete(id);
		return ResponseEntity.ok(null);
	}
    
}
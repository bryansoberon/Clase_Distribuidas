package com.bryan.serviceproducto.service;
import com.bryan.serviceproducto.entity.Producto;
import java.util.List;
import org.springframework.data.domain.Pageable;
public interface ProductoService {
    public List<Producto> getAll(Pageable page);
    public Producto getById(int id);
    public Producto create(Producto producto);
    public Producto update(Producto producto);

    public void delete(int id);

}




package com.bryan.serviceproducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bryan.serviceproducto.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{


}
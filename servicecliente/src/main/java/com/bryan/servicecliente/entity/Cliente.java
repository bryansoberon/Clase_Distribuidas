package com.bryan.servicecliente.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;

    @Column(nullable = false, unique = true, length = 20)
    private String documento;

    @Column(length = 150)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(nullable = false, unique = true, length = 100)
    private String email;
}

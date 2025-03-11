package com.desafio_picpay.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="tb_usuario")
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique=true, nullable = false)
    private Long cpf;

    @Column(unique=true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    private Boolean lojista;

    // boolean ou Boolean
    // boolean = true ou false
    // Boolean = true, false ou null

    // boilerplate code - runtime
}
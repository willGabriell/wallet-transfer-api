package com.wallet_transfer_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="tb_usuario")
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @CPF
    @Column(unique=true, nullable = false)
    private String cpf;

    @Column(unique=true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;
}
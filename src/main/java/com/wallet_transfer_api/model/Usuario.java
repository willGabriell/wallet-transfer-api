package com.wallet_transfer_api.model;

import com.wallet_transfer_api.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tb_usuario")
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
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
    private BigDecimal saldo;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoUsuario tipo;

    @CreatedDate
    @Column(nullable = false)
    private Date createDate;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updateDate;
}
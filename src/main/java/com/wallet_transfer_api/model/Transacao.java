package com.wallet_transfer_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_pagador")
    private Usuario pagador;

    @ManyToOne
    @JoinColumn(name = "id_recebedor")
    private Usuario recebedor;

    @CreatedDate
    private LocalDateTime data;

}

package com.wallet_transfer_api.dto;

import com.wallet_transfer_api.model.Transacao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class TransacaoResponseDto {
    private Long id;
    private String nomePagador;
    private String nomeRecebedor;
    private BigDecimal valor;

    public TransacaoResponseDto(Transacao transacao) {
        this.id = transacao.getId();
        this.nomePagador = transacao.getPagador().getNome();
        this.nomeRecebedor = transacao.getRecebedor().getNome();
        this.valor = transacao.getValor();
    }

}

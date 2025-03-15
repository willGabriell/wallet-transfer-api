package com.wallet_transfer_api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class TransacaoRequestDto {
    private Long idPagador;
    private Long idRecebedor;
    private BigDecimal valor;
}

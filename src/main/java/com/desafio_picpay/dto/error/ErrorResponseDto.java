package com.desafio_picpay.dto.error;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponseDto {

    private String mensagem;

    public ErrorResponseDto(String mensagem) {
        this.mensagem = mensagem;
    }

}

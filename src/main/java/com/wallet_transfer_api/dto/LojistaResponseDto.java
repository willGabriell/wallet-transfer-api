package com.wallet_transfer_api.dto;

import com.wallet_transfer_api.model.Lojista;

public class LojistaResponseDto {

    Long id;
    String nome;
    String cnpj;
    String email;

    public LojistaResponseDto(Lojista lojista) {
        this.id = lojista.getId();
        this.nome = lojista.getNome();
        this.cnpj = lojista.getCnpj();
        this.email = lojista.getEmail();
    }

}

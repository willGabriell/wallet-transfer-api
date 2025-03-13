package com.wallet_transfer_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter @Setter
public class LojistaRequestDto {

    @NotBlank
    private String nome;

    @CNPJ
    @NotBlank
    private String cnpj;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;
}

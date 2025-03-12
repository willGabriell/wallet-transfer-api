package com.wallet_transfer_api.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter @Setter
public class UsuarioRequestDto {

    private String nome;
    @CPF
    private String cpf;
    private String email;
    private String senha;
    private Boolean lojista;

}

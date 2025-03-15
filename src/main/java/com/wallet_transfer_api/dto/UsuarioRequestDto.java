package com.wallet_transfer_api.dto;

import com.wallet_transfer_api.model.enums.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Getter @Setter
public class UsuarioRequestDto {

    @NotBlank
    private String nome;

    @CPF
    @NotBlank
    private String cpf;

    @NotBlank
    private String email;

    @NotNull
    private BigDecimal saldo;

    @NotBlank
    private String senha;

    @NotNull
    private TipoUsuario tipo;

}

package com.wallet_transfer_api.dto;

import com.wallet_transfer_api.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioResponseDto {

    private Long id;
    private String nome;
    private String email;

    public UsuarioResponseDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

}

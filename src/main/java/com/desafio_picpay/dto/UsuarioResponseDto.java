package com.desafio_picpay.dto;

import com.desafio_picpay.model.Usuario;
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

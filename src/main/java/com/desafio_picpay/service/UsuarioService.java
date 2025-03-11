package com.desafio_picpay.service;

import com.desafio_picpay.model.Usuario;
import com.desafio_picpay.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void cadastrar(Usuario usuario) {
        if(usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        usuarioRepository.save(usuario);
    }

}

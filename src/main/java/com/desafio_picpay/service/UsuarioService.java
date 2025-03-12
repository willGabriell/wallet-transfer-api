package com.desafio_picpay.service;

import com.desafio_picpay.arq.util.ValidatorUtil;
import com.desafio_picpay.arq.validator.UsuarioValidator;
import com.desafio_picpay.dto.UsuarioRequestDto;
import com.desafio_picpay.model.Usuario;
import com.desafio_picpay.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator usuarioValidator;

    public Usuario cadastrar(UsuarioRequestDto usuarioDto) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setCpf(usuarioDto.getCpf());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());
        usuario.setLojista(usuarioDto.getLojista());

        usuarioValidator.validaCamposObrigatorios(usuario);
        usuarioValidator.validaDuplicidade(usuario);

        return usuarioRepository.save(usuario);

    }





}

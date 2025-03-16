package com.wallet_transfer_api.arq.validator;

import com.wallet_transfer_api.model.Usuario;
import com.wallet_transfer_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioValidator {

    private final UsuarioRepository usuarioRepository;

    public boolean validaDuplicidade(Usuario usuario) {
        if(usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if(usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        return true;
    }

    public boolean validaCamposObrigatorios(Usuario usuario) {
        if(ValidatorUtil.isEmpty(usuario)) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }

        if(ValidatorUtil.isEmpty(usuario.getNome())) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }

        if(ValidatorUtil.isEmpty(usuario.getCpf())) {
            throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        }

        if(ValidatorUtil.isEmpty(usuario.getEmail())) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }

        if(ValidatorUtil.isEmpty(usuario.getSenha())) {
            throw new IllegalArgumentException("Senha não pode ser nulo ou vazio");
        }

        if(ValidatorUtil.isEmpty(usuario.getTipo())) {
            throw new IllegalArgumentException("TipoUsuario não pode ser nulo ou vazio");
        }

        return true;
    }
}

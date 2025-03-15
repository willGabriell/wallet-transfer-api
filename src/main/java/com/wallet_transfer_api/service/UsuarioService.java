package com.wallet_transfer_api.service;

import com.wallet_transfer_api.arq.validator.ValidatorUtil;
import com.wallet_transfer_api.arq.validator.UsuarioValidator;
import com.wallet_transfer_api.dto.UsuarioRequestDto;
import com.wallet_transfer_api.model.Usuario;
import com.wallet_transfer_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        usuario.setTipo(usuarioDto.getTipo());
        usuario.setSaldo(usuarioDto.getSaldo());

        usuarioValidator.validaCamposObrigatorios(usuario);
        usuarioValidator.validaDuplicidade(usuario);

        return usuarioRepository.save(usuario);

    }

    public Usuario atualizar(UsuarioRequestDto usuarioDto) {

        Optional<Usuario> findUsuario = usuarioRepository.findByCpf(usuarioDto.getCpf());

        if(findUsuario.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        Usuario usuario = findUsuario.get();
        usuario.setNome(usuarioDto.getNome());
        usuario.setCpf(usuarioDto.getCpf());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());
        usuario.setTipo(usuarioDto.getTipo());

        usuarioValidator.validaCamposObrigatorios(usuario);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Long id) {

        if(ValidatorUtil.isEmpty(id)) {
            throw new IllegalArgumentException("Não é possível buscar o usuário");
        }

        return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public void deletarUsuario(Long id) {

        Usuario usuario = buscarUsuario(id);

        usuarioRepository.delete(usuario);
    }
}

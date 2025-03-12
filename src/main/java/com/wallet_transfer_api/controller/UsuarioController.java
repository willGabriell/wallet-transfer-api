package com.wallet_transfer_api.controller;

import com.wallet_transfer_api.dto.UsuarioRequestDto;
import com.wallet_transfer_api.dto.UsuarioResponseDto;
import com.wallet_transfer_api.model.Usuario;
import com.wallet_transfer_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDto> cadastrarUsuario(@Valid @RequestBody UsuarioRequestDto usuarioDto) {

        Usuario usuario = usuarioService.cadastrar(usuarioDto);
        UsuarioResponseDto responseDto = new UsuarioResponseDto(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<UsuarioResponseDto> atualizarUsuario(@Valid @RequestBody UsuarioRequestDto usuarioDto) {

        Usuario usuario = usuarioService.atualizar(usuarioDto);
        UsuarioResponseDto responseDto = new UsuarioResponseDto(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }

}

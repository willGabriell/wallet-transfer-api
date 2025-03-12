package com.desafio_picpay.controller;

import com.desafio_picpay.dto.UsuarioRequestDto;
import com.desafio_picpay.dto.UsuarioResponseDto;
import com.desafio_picpay.model.Usuario;
import com.desafio_picpay.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

package com.desafio_picpay.controller;

import com.desafio_picpay.model.Usuario;
import com.desafio_picpay.service.UsuarioService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

        if(usuario == null) {
            return ResponseEntity.badRequest().build();
        }

        usuarioService.cadastrar(usuario);

        return ResponseEntity.ok(usuario);
    }

}

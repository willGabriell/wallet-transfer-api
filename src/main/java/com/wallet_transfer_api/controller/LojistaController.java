package com.wallet_transfer_api.controller;

import com.wallet_transfer_api.dto.LojistaRequestDto;
import com.wallet_transfer_api.dto.LojistaResponseDto;
import com.wallet_transfer_api.model.Lojista;
import com.wallet_transfer_api.service.LojistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojista")
@RequiredArgsConstructor
public class LojistaController {

    private final LojistaService lojistaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<LojistaResponseDto> cadastrarLojista(@Valid @RequestBody LojistaRequestDto lojistaDto) {
        Lojista lojista = lojistaService.cadastrar(lojistaDto);
        LojistaResponseDto responseDto = new LojistaResponseDto(lojista);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<LojistaResponseDto> atualizarLojista(@Valid @RequestBody LojistaRequestDto lojistaDto) {
        Lojista lojista = lojistaService.atualizar(lojistaDto);
        LojistaResponseDto responseDto = new LojistaResponseDto(lojista);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/{id}")
    public Lojista buscarLojista(Long id) {
        return lojistaService.buscarLojista(id);
    }

    @GetMapping
    public List<Lojista> listarLojistas() {
        return lojistaService.listarLojistas();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarLojista(Long id) {
        lojistaService.deletarLojista(id);
    }

}

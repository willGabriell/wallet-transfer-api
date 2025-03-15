package com.wallet_transfer_api.controller;

import com.wallet_transfer_api.arq.validator.TransacaoValidator;
import com.wallet_transfer_api.arq.validator.ValidatorUtil;
import com.wallet_transfer_api.dto.TransacaoRequestDto;
import com.wallet_transfer_api.dto.TransacaoResponseDto;
import com.wallet_transfer_api.model.Transacao;
import com.wallet_transfer_api.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final TransacaoValidator transacaoValidator;

    @PostMapping("/realizar")
    public ResponseEntity<TransacaoResponseDto> transacao(@RequestBody TransacaoRequestDto transacao) {

        transacaoValidator.validarCampos(transacao);

        Transacao transacaoRealizada = transacaoService.realizarTransacao(transacao);
        TransacaoResponseDto responseDto = new TransacaoResponseDto(transacaoRealizada);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}

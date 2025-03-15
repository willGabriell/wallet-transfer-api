package com.wallet_transfer_api.arq.validator;

import com.wallet_transfer_api.dto.TransacaoRequestDto;
import org.springframework.stereotype.Component;

@Component
public class TransacaoValidator {
    public void validarCampos(TransacaoRequestDto dto) {
        if(ValidatorUtil.isEmpty(dto.getValor())) {
            throw new IllegalArgumentException("Valor da transação não pode ser vazio");
        }

        if(ValidatorUtil.isEmpty(dto.getIdPagador())) {
            throw new IllegalArgumentException("Id do pagador não pode ser vazio");
        }

        if(ValidatorUtil.isEmpty(dto.getIdRecebedor())) {
            throw new IllegalArgumentException("Id do recebedor não pode ser vazio");
        }
    }
}

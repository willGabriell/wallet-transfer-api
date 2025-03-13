package com.wallet_transfer_api.arq.validator;

import com.wallet_transfer_api.model.Lojista;
import com.wallet_transfer_api.repository.LojistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LojistaValidator {

    private final LojistaRepository lojistaRepository;

    public void validaCamposObrigatorios(Lojista lojista) {
        if(lojista.getNome() == null || lojista.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if(lojista.getCnpj() == null || lojista.getCnpj().isEmpty()) {
            throw new IllegalArgumentException("CNPJ é obrigatório");
        }
        if(lojista.getEmail() == null || lojista.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        if(lojista.getSenha() == null || lojista.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }
    }

    public void validaDuplicidade(Lojista lojista) {
        Lojista findLojista = lojistaRepository.findByCnpj(lojista.getCnpj());
        if(findLojista != null) {
            throw new IllegalArgumentException("CNPJ já cadastrado");
        }
        findLojista = lojistaRepository.findByEmail(lojista.getEmail());
        if(findLojista != null) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
    }

}

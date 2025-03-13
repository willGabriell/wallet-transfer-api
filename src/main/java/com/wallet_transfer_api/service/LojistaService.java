package com.wallet_transfer_api.service;

import com.wallet_transfer_api.arq.validator.LojistaValidator;
import com.wallet_transfer_api.arq.validator.ValidatorUtil;
import com.wallet_transfer_api.dto.LojistaRequestDto;
import com.wallet_transfer_api.model.Lojista;
import com.wallet_transfer_api.repository.LojistaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LojistaService {

    private final LojistaRepository lojistaRepository;
    private final LojistaValidator lojistaValidator;

    public Lojista cadastrar(LojistaRequestDto dto) {
        Lojista lojista = new Lojista();
        lojista.setNome(dto.getNome());
        lojista.setCnpj(dto.getCnpj());
        lojista.setEmail(dto.getEmail());
        lojista.setSenha(dto.getSenha());

        lojistaValidator.validaCamposObrigatorios(lojista);
        lojistaValidator.validaDuplicidade(lojista);

        return lojistaRepository.save(lojista);
    }

    public Lojista atualizar(LojistaRequestDto dto) {
        Lojista lojista = lojistaRepository.findByCnpj(dto.getCnpj());
        if(ValidatorUtil.isEmpty(lojista)) {
            throw new IllegalArgumentException("Lojista não encontrado");
        }
        lojista.setNome(dto.getNome());
        lojista.setEmail(dto.getEmail());
        lojista.setSenha(dto.getSenha());

        lojistaValidator.validaCamposObrigatorios(lojista);

       return lojistaRepository.save(lojista);
    }

    public Lojista buscarLojista(Long id) {
        if(ValidatorUtil.isEmpty(id)) {
            throw new IllegalArgumentException("Não é possivel buscar o logista");
        }

        return lojistaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Lojista não encontrado"));
    }

    public void deletarLojista(Long id) {
        if(ValidatorUtil.isEmpty(id)) {
            throw new IllegalArgumentException("Não é possivel deletar o logista");
        }

        lojistaRepository.deleteById(id);
    }

    public List<Lojista> listarLojistas() {
        return lojistaRepository.findAll();
    }

}

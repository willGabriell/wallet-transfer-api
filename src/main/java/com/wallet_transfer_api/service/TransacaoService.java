package com.wallet_transfer_api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet_transfer_api.dto.TransacaoRequestDto;
import com.wallet_transfer_api.model.Transacao;
import com.wallet_transfer_api.model.Usuario;
import com.wallet_transfer_api.model.enums.TipoUsuario;
import com.wallet_transfer_api.repository.TransacaoRepository;
import com.wallet_transfer_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public Transacao realizarTransacao(TransacaoRequestDto transacaoDto) {

        if(!isAutorizado()) {
            throw new IllegalArgumentException("Transação não autorizada");
        }

        Usuario pagador = usuarioRepository.findById(transacaoDto.getIdPagador()).orElseThrow(() -> new IllegalArgumentException("Pagador não encontrado"));
        Usuario recebedor = usuarioRepository.findById(transacaoDto.getIdRecebedor()).orElseThrow(() -> new IllegalArgumentException("Recebedor não encontrado"));

        if(pagador.getTipo().equals(TipoUsuario.LOJISTA)) {
            throw new IllegalArgumentException("Lojistas não podem realizar transferências");
        }

        if(pagador.getId().equals(recebedor.getId())) {
            throw new IllegalArgumentException("Não é possível transferir para você mesmo");
        }

        if(pagador.getSaldo().compareTo(transacaoDto.getValor()) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        pagador.setSaldo(pagador.getSaldo().subtract(transacaoDto.getValor()));
        recebedor.setSaldo(recebedor.getSaldo().add(transacaoDto.getValor()));

        usuarioRepository.save(pagador);
        usuarioRepository.save(recebedor);

        Transacao transacao = new Transacao();
        transacao.setPagador(pagador);
        transacao.setRecebedor(recebedor);
        transacao.setValor(transacaoDto.getValor());

        return transacaoRepository.save(transacao);
    }

    private boolean isAutorizado() {
        String url = "https://util.devi.tools/api/v2/authorize";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        HttpStatusCode status = response.getStatusCode();
        return status == HttpStatus.OK;
    }

}

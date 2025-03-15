package com.wallet_transfer_api.repository;

import com.wallet_transfer_api.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}

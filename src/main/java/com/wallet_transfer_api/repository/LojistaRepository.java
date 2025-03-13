package com.wallet_transfer_api.repository;

import com.wallet_transfer_api.model.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojistaRepository extends JpaRepository<Lojista,Long> {
    Lojista findByEmail(String email);
    Lojista findByCnpj(String cnpj);
}

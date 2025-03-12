package com.wallet_transfer_api.repository;

import com.wallet_transfer_api.model.Usuario;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);

    Optional<Usuario> findByCpf(@CPF String cpf);
}

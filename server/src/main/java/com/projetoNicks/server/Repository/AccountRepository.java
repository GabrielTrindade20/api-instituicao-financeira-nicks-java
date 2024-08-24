package com.projetoNicks.server.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoNicks.server.Entities.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

	Optional<AccountEntity> findByAccountNumber(String accountNumber);
}

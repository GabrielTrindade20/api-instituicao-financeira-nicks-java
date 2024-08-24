package com.projetoNicks.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.projetoNicks.server.DTO.AccountDTO;
import com.projetoNicks.server.Entities.AccountEntity;
import com.projetoNicks.server.Repository.AccountRepository;

public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	// constructor
	public AccountService(AccountRepository contaRepository) {
		this.accountRepository = contaRepository;
	}

	// method to convert Entity to DTO
	private AccountEntity mapDtotoEntity(AccountDTO accountDTO) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccountNumber(accountDTO.getAccountNumber());
		accountEntity.setBalance(accountDTO.getBalance());
		return accountEntity;
	}

	// method to convert DTO to Entity
	private AccountDTO mapEntitytoDto(AccountEntity accountEntity) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountNumber(accountEntity.getAccountNumber());
		accountDTO.setBalance(accountEntity.getBalance());
		return accountDTO;

	}

	// method to create a new account
	public AccountDTO createAccount(AccountDTO accountDTO) {

		// convert AccountDTO to AccountEntity
		AccountEntity accountEntity = mapDtotoEntity(accountDTO);

		// save the entity on database
		AccountEntity savedEntity = accountRepository.save(accountEntity);

		// Convert the saved entity to back to DTO
		return mapEntitytoDto(accountEntity);
	}

	public AccountDTO getAccount(String code) {
		// gets a database account
		AccountEntity accountEntity = accountRepository.findByAccountNumber(code)
				.orElseThrow(() -> new RuntimeException("Account not found"));
		
		return mapEntitytoDto(accountEntity);
	}

}

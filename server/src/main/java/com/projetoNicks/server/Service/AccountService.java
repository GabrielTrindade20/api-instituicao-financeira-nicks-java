package com.projetoNicks.server.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.projetoNicks.server.DTO.AccountDTO;
import com.projetoNicks.server.Entities.AccountEntity;
import com.projetoNicks.server.Repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	// method to convert Entity to DTO
	private AccountEntity mapDtotoEntity(AccountDTO accountDTO) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setId(accountDTO.getId());
		accountEntity.setAccountNumber(accountDTO.getAccountNumber());
		accountEntity.setBalance(accountDTO.getBalance());
		return accountEntity;
	}

	// method to convert DTO to Entity
	private AccountDTO mapEntitytoDto(AccountEntity accountEntity) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(accountEntity.getId());
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
		return mapEntitytoDto(savedEntity);
	}

	public AccountDTO getAccountByCode(String code) {
		// gets a database account
		AccountEntity accountEntity = accountRepository.findByAccountNumber(code)
				.orElseThrow(() -> new RuntimeException("Account not found"));
		
		return mapEntitytoDto(accountEntity);
	}

	//method to get all account
	public List<AccountDTO> getAllAccount() {
		return accountRepository.findAll().stream().map(this::mapEntitytoDto).collect(Collectors.toList());
	}
}

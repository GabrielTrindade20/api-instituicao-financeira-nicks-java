package com.projetoNicks.server.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	// method to get all account
	public List<AccountDTO> getAllAccount() {
		return accountRepository.findAll().stream().map(this::mapEntitytoDto).collect(Collectors.toList());
	}

	// method to get account by number account
	public AccountDTO getAccountByNumberAccount(String accountNumber) {
		AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new RuntimeException("Account not found"));
		
		return mapEntitytoDto(accountEntity);
	}

	// Method to generete automatic account number
	public String generateAccountNumber() {
		Random random = new Random();
		int numberPatt = random.nextInt(1000000); // generate a number between 0 to 999999
		int chackDigit = random.nextInt(10); // generate a digit of verification of 0 to 10
		return String.format("%06d-%d", numberPatt, chackDigit);
	}

	// method to ensure that the account number is unique
	private String generateUniqueAccountNumber() {
		String accountNumber;
		do {
			accountNumber = generateAccountNumber();
		} while (accountRepository.existsByAccountNumber(accountNumber));
		return accountNumber;
	}

	// method to create a new account
	public AccountDTO createAccount(AccountDTO accountDTO) {
		// convert AccountDTO to AccountEntity
		AccountEntity accountEntity = mapDtotoEntity(accountDTO);

		// set the account number
		accountEntity.setAccountNumber(generateUniqueAccountNumber());

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

	// method to update a account

}

package com.projetoNicks.server.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoNicks.server.DTO.AccountDTO;
import com.projetoNicks.server.Entities.AccountEntity;
import com.projetoNicks.server.Service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	private final AccountService accountService;

	AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/allAccount")
	public ResponseEntity<List<AccountDTO>> getAllAccount() {
		List<AccountDTO> accounts = accountService.getAllAccount();
		return ResponseEntity.ok(accounts);
	}

	@PostMapping("/createAccount")
	public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
		AccountDTO createdAccount = accountService.createAccount(accountDTO);
		return ResponseEntity.status(201).body(createdAccount);
	}

	@GetMapping("/getAccount/{accountNumber}")
	public ResponseEntity<AccountDTO> getAccountByNumberAccount(@PathVariable String accountNumber) {
		AccountDTO account = accountService.getAccountByNumberAccount(accountNumber);
		return ResponseEntity.ok(account);
	}
	
	@PutMapping("/update/{accountNumber}")
	public ResponseEntity<Void> updateBalance(@PathVariable String accountNumber, @RequestBody double newBalance){
		accountService.updateBalance(accountNumber, newBalance);
		return ResponseEntity.ok().build();
	}

}

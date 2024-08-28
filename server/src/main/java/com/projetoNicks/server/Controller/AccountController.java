package com.projetoNicks.server.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoNicks.server.DTO.AccountDTO;
import com.projetoNicks.server.Entities.AccountEntity;
import com.projetoNicks.server.Service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

}

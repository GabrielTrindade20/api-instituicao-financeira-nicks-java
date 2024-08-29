package com.projetoNicks.server.DTO;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Builder
@Data
@Getter 
@Setter
public class AccountDTO {
	
	private Long id;
	
	@Pattern(regexp = "^[0-9]{6}-[0-9]{1}", message = "invalid format. Use xxxxxx-x")
	private String accountNumber;
	private Double balance;
	
	public AccountDTO(Long id, String accountNumber, Double balance) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public AccountDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}





	
}

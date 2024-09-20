package com.projetoNicks.server.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Data
@Getter @Setter
public class CustomerDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String password;
	
	private List<AddressDTO> address;
	private List<AccountDTO> account;
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(Long id, String nome, String email, String telefone, String cpf, String password) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<AddressDTO> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDTO> address) {
		this.address = address;
	}

	public List<AccountDTO> getAccount() {
		return account;
	}

	public void setAccount(List<AccountDTO> account) {
		this.account = account;
	}

	
	
}

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
public class ClienteDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	
	private List<EnderecoDTO> enderecos;
	private List<AccountDTO> contas;

	public ClienteDTO(Long id, String nome, String email, String telefone, String cpf) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
	}

}

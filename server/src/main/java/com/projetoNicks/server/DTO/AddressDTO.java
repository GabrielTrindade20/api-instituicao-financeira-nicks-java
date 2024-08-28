package com.projetoNicks.server.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter @Setter
public class AddressDTO {

	private Long id;
	private String logradouro;
	private String bairro;
	private int numero;
	private int cep;
	private String cidade;
	private String estado;
	
	public AddressDTO(Long id, String logradouro, String bairro, int numero, int cep, String cidade, String estado) {
		this.id = id;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
}

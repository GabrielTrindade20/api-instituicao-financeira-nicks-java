package com.projetoNicks.server.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Builder
@Data
@Getter @Setter
public class ContaDTO {

	private Long id;
	private int codigo;
	private Double salario;
	
	public ContaDTO(Long id, int codigo, Double salario) {
		this.id = id;
		this.codigo = codigo;
		this.salario = salario;
	}
}

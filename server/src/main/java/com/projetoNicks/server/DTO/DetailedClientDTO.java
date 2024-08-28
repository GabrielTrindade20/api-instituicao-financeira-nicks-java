package com.projetoNicks.server.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
public class DetailedClientDTO {
	private Long idCliente;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String senha;
    private Long idEndereco;
    private String logradouro;
    private String bairro;
    private Integer numero;
    private Integer cep;
    private String cidade;
    private String estado;
    private Long idConta;
    private Integer codigoConta;
    private Double saldoConta;
    
    
	public DetailedClientDTO(Long idCliente, String nome, String email, String cpf, String telefone, String senha,
			Long idEndereco, String logradouro, String bairro, Integer numero, Integer cep, String cidade,
			String estado, Long idConta, Integer codigoConta, Double saldoConta) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.senha = senha;
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.idConta = idConta;
		this.codigoConta = codigoConta;
		this.saldoConta = saldoConta;
	}
    
    
    
}

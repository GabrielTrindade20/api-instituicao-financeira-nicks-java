package com.projetoNicks.server.Entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TableConta")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContaEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idConta")
	private Long Id;

	@Column(name = "codigo")
	private int codigo;

	@Column(name = "saldo")
	private Double saldo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_tipoConta_idTipoConta")
	private TipoContaEntity tipoConta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_agencia_idAgencia")
	private AgenciaEntity agencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_reserva_idReserva")
	private ReservaEntity reserva;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_cliente_idCliente")
	private ClienteEntity cliente;

	@ManyToMany(mappedBy = "contas")
	private List<TransacaoEntity> transacoes;

}

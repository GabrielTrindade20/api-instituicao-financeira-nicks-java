package com.projetoNicks.server.Entities;

import java.time.ZonedDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TableTransacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TransactionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTransacao")
	private Long id;

	@Column(name = "datatime")
	private ZonedDateTime dataTime;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "valor")
	private Double valor;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "TableConta_tem_TableTransacao", 
				joinColumns = @JoinColumn(name = "Fk_transacao_idTransacao"), 
				inverseJoinColumns = @JoinColumn(name = "Fk_conta_idConta")
	)
	private List<AccountEntity> contas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_extrato_idExtrato")
	private ExtratoEntity extrato;

}

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TableBankStatement")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class BankStatementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBankStatement")
	private Long Id;
	
	@Column(name = "dataTime")
	private ZonedDateTime datetime;
	
	@Column(name = "transactionType")
	private String transactionType;
	
	@Column(name = "value")
	private Double value;
	
	@OneToMany(mappedBy = "bankStatement", fetch = FetchType.LAZY)
	private List<TransactionsEntity> transaction;
}

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
@Table(name = "TableTransaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TransactionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTransaction")
	private Long id;

	@Column(name = "datatime")
	private ZonedDateTime dataTime;

	@Column(name = "type")
	private String type;

	@Column(name = "value")
	private Double value;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "TableAccount_has_TableTransaction", 
				joinColumns = @JoinColumn(name = "Fk_transaction_idTransaction"), 
				inverseJoinColumns = @JoinColumn(name = "Fk_account_idAccont")
	)
	private List<AccountEntity> account;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_bankStatement_idBankStatement")
	private BankStatementEntity bankStatement;

}

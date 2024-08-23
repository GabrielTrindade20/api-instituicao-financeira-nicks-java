package com.projetoNicks.server.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TablePix")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PixEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPix")
	private Long Id;
	
	@Column(name = "key")
	private int key;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "Fk_account_idAccount", referencedColumnName = "idAccount"),
		@JoinColumn(name = "Fk_accountType_idAccountType", referencedColumnName = "Fk_AccountType_idAccountType"),
		@JoinColumn(name = "Fk_agency_idAgency", referencedColumnName = "Fk_agency_idAgency"),
		@JoinColumn(name = "Fk_reserve_idReserve", referencedColumnName = "Fk_reserve_idReserve")
	})
	private AccountEntity Account;
	
}

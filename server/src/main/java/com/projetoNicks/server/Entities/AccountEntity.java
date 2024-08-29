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
@Table(name = "TableAccount")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAccount")
	private Long Id;
	
	public AccountEntity() {
		
	}


	@Column(name = "account_number", length = 8, unique = true, nullable = false)
	private String accountNumber;

	public AccountEntity(Long id, String accountNumber, Double balance, AccountTypeEntity accountType, AgencyEntity agency,
			ReserveEntity reserve, CustomerEntity customer, List<TransactionsEntity> transactions) {
		super();
		Id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountType = accountType;
		this.agency = agency;
		this.reserve = reserve;
		this.customer = customer;
		this.transactions = transactions;
	}

	@Column(name = "balance")
	private Double balance;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_accountType_idAccountType")
	private AccountTypeEntity accountType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_agency_idAgency")
	private AgencyEntity agency;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_reserve_idReserve")
	private ReserveEntity reserve;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Fk_customer_idCustomer")
	private CustomerEntity customer;

	@ManyToMany(mappedBy = "account")
	private List<TransactionsEntity> transactions;
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public AccountTypeEntity getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEntity accountType) {
		this.accountType = accountType;
	}

	public AgencyEntity getAgency() {
		return agency;
	}

	public void setAgency(AgencyEntity agency) {
		this.agency = agency;
	}

	public ReserveEntity getReserve() {
		return reserve;
	}

	public void setReserve(ReserveEntity reserve) {
		this.reserve = reserve;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<TransactionsEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionsEntity> transactions) {
		this.transactions = transactions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
}

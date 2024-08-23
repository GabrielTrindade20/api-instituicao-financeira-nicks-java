package com.projetoNicks.server.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "TableAddress")
@Getter @Setter
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAddress")
	private Long Id;
	
	@Column(name = "publicPlace")
	private String publicPlace;
	
	@Column(name = "district ")
	private String district;
	
	@Column(name = "houseNumber")
	private int houseNumber;
	
	@Column(name = "zipCode")
	private int zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
}

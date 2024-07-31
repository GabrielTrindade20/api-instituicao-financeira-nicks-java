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
	
	@Column(name = "chave")
	private int chave;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "Fk_conta_idConta", referencedColumnName = "idConta"),
		@JoinColumn(name = "Fk_tipoConta_idTipoConta", referencedColumnName = "Fk_tipoConta_idTipoConta"),
		@JoinColumn(name = "Fk_agencia_idAgencia", referencedColumnName = "Fk_agencia_idAgencia"),
		@JoinColumn(name = "Fk_reserva_idReserva", referencedColumnName = "Fk_reserva_idReserva")
	})
	private ContaEntity conta;
	
}

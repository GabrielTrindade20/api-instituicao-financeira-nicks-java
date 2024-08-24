package com.projetoNicks.server.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoNicks.server.DTO.ClienteDTO;
import com.projetoNicks.server.DTO.ClienteDetalhadoDTO;
import com.projetoNicks.server.Entities.CustomerEntity;
import com.projetoNicks.server.Entities.AccountEntity;
import com.projetoNicks.server.Entities.AddressEntity;
import com.projetoNicks.server.Repository.CustomerRepository;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class ClienteService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerEntity> getList() {
		return customerRepository.findAll();
	}

}

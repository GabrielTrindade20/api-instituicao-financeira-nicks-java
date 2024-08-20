package com.projetoNicks.server.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoNicks.server.DTO.ClienteDTO;
import com.projetoNicks.server.DTO.ClienteDetalhadoDTO;
import com.projetoNicks.server.Entities.ClienteEntity;
import com.projetoNicks.server.Entities.ContaEntity;
import com.projetoNicks.server.Entities.EnderecoEntity;
import com.projetoNicks.server.Repository.ClienteRepository;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteEntity> getList() {
		return clienteRepository.findAll();
	}

}

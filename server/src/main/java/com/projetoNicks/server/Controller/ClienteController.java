package com.projetoNicks.server.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoNicks.server.DTO.ClienteDTO;
import com.projetoNicks.server.DTO.ClienteDetalhadoDTO;
import com.projetoNicks.server.Repository.ClienteRepository;
import com.projetoNicks.server.Service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

	private final ClienteRepository clienteRepository;
	private final ClienteService clienteService;

	//Traz todos os clientes na base de dados
	@GetMapping
	public List<ClienteDTO> getAllClientes(){
		return clienteService.getAllClientes();
	}
	
	//Traz os clientes com o id selecionado
	@GetMapping("/{id}")
	 public ResponseEntity<ClienteDetalhadoDTO> buscarClienteDetalhado(@PathVariable Long id) {
        ClienteDetalhadoDTO clienteDetalhadoDTO = clienteService.buscarClienteDetalhado(id);
        return ResponseEntity.ok(clienteDetalhadoDTO);
    }
	
	
	
}

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

	public List<ClienteDTO> getAllClientes(){
		return clienteRepository.findAll().stream()
				.map(cliente -> new ClienteDTO(
						cliente.getIdCliente(),
						cliente.getNome(),
						cliente.getEmail(),
						cliente.getTelefone(),
						cliente.getCpf()
						))
				.collect(Collectors.toList());
	}
	
	public Optional<ClienteDTO> getClienteById(Long id){
		return clienteRepository.findById(id)
				.map(cliente -> new ClienteDTO(
						cliente.getIdCliente(),
						cliente.getNome(),
						cliente.getEmail(),
						cliente.getTelefone(),
						cliente.getCpf()
						));			
	}
	
	 public ClienteDetalhadoDTO buscarClienteDetalhado(Long idCliente) {
	        ClienteEntity clienteEntity = clienteRepository.findById(idCliente)
	                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

	        ClienteDetalhadoDTO clienteDetalhadoDTO = new ClienteDetalhadoDTO();
	        clienteDetalhadoDTO.setIdCliente(clienteEntity.getIdCliente());
	        clienteDetalhadoDTO.setNome(clienteEntity.getNome());
	        clienteDetalhadoDTO.setEmail(clienteEntity.getEmail());
	        clienteDetalhadoDTO.setCpf(clienteEntity.getCpf());
	        clienteDetalhadoDTO.setTelefone(clienteEntity.getTelefone());
	        clienteDetalhadoDTO.setSenha(clienteEntity.getSenha());

	        // Preencher dados do endereço
	        EnderecoEntity endereco = clienteEntity.getEnderecos().get(0); // Supondo que o cliente tenha apenas um endereço
	        clienteDetalhadoDTO.setIdEndereco(endereco.getId());
	        clienteDetalhadoDTO.setLogradouro(endereco.getLogradouro());
	        clienteDetalhadoDTO.setBairro(endereco.getBairro());
	        clienteDetalhadoDTO.setNumero(endereco.getNumero());
	        clienteDetalhadoDTO.setCep(endereco.getCep());
	        clienteDetalhadoDTO.setCidade(endereco.getCidade());
	        clienteDetalhadoDTO.setEstado(endereco.getEstado());

	        // Preencher dados da conta
	        ContaEntity conta = clienteEntity.getContas().get(0); // Supondo que o cliente tenha apenas uma conta
	        clienteDetalhadoDTO.setIdConta(conta.getId());
	        clienteDetalhadoDTO.setCodigoConta(conta.getCodigo());
	        clienteDetalhadoDTO.setSaldoConta(conta.getSaldo());

	        return clienteDetalhadoDTO;
	    }
	
}

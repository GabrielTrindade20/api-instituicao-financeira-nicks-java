package com.projetoNicks.server.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoNicks.server.DTO.AccountDTO;
import com.projetoNicks.server.DTO.AddressDTO;
import com.projetoNicks.server.DTO.CustomerDTO;
import com.projetoNicks.server.DTO.DetailedClientDTO;
import com.projetoNicks.server.Entities.CustomerEntity;
import com.projetoNicks.server.Entities.AccountEntity;
import com.projetoNicks.server.Entities.AddressEntity;
import com.projetoNicks.server.Repository.CustomerRepository;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerEntity> getList() {
		return customerRepository.findAll();
	}

	// method to convert Entity to dto
	private CustomerEntity mapDtoEntity(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(customerDTO.getId());
		customerEntity.setCpf(customerDTO.getCpf());
		customerEntity.setEmail(customerDTO.getEmail());
		customerEntity.setName(customerDTO.getNome());
		customerEntity.setTelephone(customerDTO.getTelefone());
		customerEntity.setPassword(customerDTO.getPassword());
		return customerEntity;
	}

	// method to convert dto to entity
	private CustomerDTO mapEntityDto(CustomerEntity customerEntity) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(customerEntity.getId());
		customerDTO.setCpf(customerEntity.getCpf());
		customerDTO.setEmail(customerEntity.getEmail());
		customerDTO.setNome(customerEntity.getName());
		customerDTO.setPassword(customerEntity.getPassword());
		customerDTO.setTelefone(customerEntity.getTelephone());

		// address mapping
		List<AddressDTO> addreesDTOs = customerEntity.getAddress().stream().map(this::mapAddressEntityToDto)
				.collect(Collectors.toList());
		customerDTO.setAddress(addreesDTOs);

		// account mapping
		List<AccountDTO> accountDTOs = customerEntity.getAccount().stream().map(this::mapAccountEntityToDto)
				.collect(Collectors.toList());
		customerDTO.setAccount(accountDTOs);

		return customerDTO;
	}

	// auxiliary methods to mapping address and Account
	private AddressDTO mapAddressEntityToDto(AddressEntity addressEntity) {
		return new AddressDTO();
	}

	private AccountDTO mapAccountEntityToDto(AccountEntity accountEntity) {
		return new AccountDTO();
	}

	// method to get all customers
	public List<CustomerDTO> getAllCustomer() {
		return customerRepository.findAll().stream().map(this::mapEntityDto).collect(Collectors.toList());
	}

}

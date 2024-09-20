package com.projetoNicks.server.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoNicks.server.DTO.CustomerDTO;
import com.projetoNicks.server.DTO.DetailedClientDTO;
import com.projetoNicks.server.Entities.CustomerEntity;
import com.projetoNicks.server.Repository.CustomerRepository;
import com.projetoNicks.server.Service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

	//Get all customer from database
	@GetMapping("/allCustomer")
	public ResponseEntity<List<CustomerDTO>> getAllClientes(){
		List<CustomerDTO> customers = customerService.getAllCustomer();
		return ResponseEntity.ok(customers);
	}
	
	//Get customer by id
//	@GetMapping("/{id}")
//	 public ResponseEntity<CustomerDTOu> buscarClienteDetalhado(@PathVariable Long id) {
//        CustomerDTO clienteDetalhadoDTO = CustomerService.buscarClienteDetalhado(id);
//        return ResponseEntity.ok(clienteDetalhadoDTO);
//    }
	
	
	
}

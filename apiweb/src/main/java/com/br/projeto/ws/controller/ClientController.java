package com.br.projeto.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto.model.Cliente;
import com.br.projeto.service.ClienteService;

@RestController
public class ClientController {
	
	@Autowired
     ClienteService serviceCliente;
	
	//End points
	@RequestMapping(value = "/clientes", method = RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {
			
		Collection<Cliente> clientes = serviceCliente.buscarTodos();
		return  new ResponseEntity<>(clientes, HttpStatus.OK);
			
			
		}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		
		 Cliente clienteSalvo = serviceCliente.cadastrar(cliente);
		 return  new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.CREATED);	
		
	}
	
	
	@RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {
		
		 Cliente clienteEncontrado = serviceCliente.buscarPorId(id);
		 
		 if(clienteEncontrado == null ) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }else {			 
			 serviceCliente.excluir(clienteEncontrado);
		 }
		 
		 return  new ResponseEntity<>(HttpStatus.OK);	
		
	}
	
	
	@RequestMapping(value = "/clientes", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
	   
	   Cliente buscarCliente = serviceCliente.buscarPorId(cliente.getId());
	   if(buscarCliente != null) {
		   Cliente clienteAlterado = serviceCliente.alterar(cliente);
		   return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);
	   }else {
	
		   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	   
		
	}

}

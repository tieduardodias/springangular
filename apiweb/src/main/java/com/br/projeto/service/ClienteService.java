package com.br.projeto.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.projeto.dao.ClienteDAO;
import com.br.projeto.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	ClienteDAO clienteDAO;
		
	
	//Neg
	public Cliente cadastrar(Cliente cliente) {
		
		return clienteDAO.save(cliente);
	}
	
	
	public Collection<Cliente> buscarTodos(){
		return clienteDAO.findAll();	
	}
	
	
	public void excluir(Cliente cliente) {
		clienteDAO.delete(cliente);
	}
	
	public Cliente buscarPorId(Integer id) {
		
		Optional<Cliente> fooOptional = clienteDAO.findById(id);
		Cliente c = new Cliente();
		if(fooOptional.isPresent()) {
	     c = fooOptional.get();
		}
		return c;
	}
	
	public Cliente alterar(Cliente c) {
		
		return clienteDAO.save(c);
	}

}

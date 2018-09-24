package com.br.projeto.dao;

import org.springframework.stereotype.Repository;

import com.br.projeto.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer>{

}

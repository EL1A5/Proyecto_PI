package com.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	
	

}

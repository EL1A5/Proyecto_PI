package com.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.Departamento;
import com.departamento.entity.Propietario;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	 public Departamento findBynumdepartamento(String numdepartamento);
	

	 
	 
	 
}

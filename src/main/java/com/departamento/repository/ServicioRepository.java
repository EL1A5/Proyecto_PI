package com.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
	

}

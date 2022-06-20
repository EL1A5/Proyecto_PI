package com.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.visita;
import com.departamento.entity.visitante;

public interface visitanteRepository extends JpaRepository<visitante,Integer>  {

	  public visitante findByDni(int dni);
}

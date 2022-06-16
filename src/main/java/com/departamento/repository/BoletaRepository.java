package com.departamento.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
	
	//public List<Date> listaFechaPago(int anio);

}

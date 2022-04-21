package com.departamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.Propietario;

public interface PropietarioService  {

	public abstract List<Propietario> listaPropietario();
	public abstract List<Propietario>listaPropietarioPorId(int id);
	public abstract Propietario GuardarPropietario(Propietario obj);
	

}

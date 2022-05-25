package com.departamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.Propietario;
import com.departamento.entity.Residente;
import com.departamento.entity.visitante;

public interface PropietarioService  {
	public List<Propietario> listarPropietarios();
    public abstract Propietario insertaActualizaPropietario(Propietario obj);
	public Propietario buscarPorIdPropietario(Integer id);
	public void eliminar (Integer id);
	public abstract Propietario buscarPorDni(String dni);
	

}

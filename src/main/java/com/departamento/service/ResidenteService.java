package com.departamento.service;

import java.util.List;
import java.util.Optional;

import com.departamento.entity.Residente;
public interface ResidenteService {

	public abstract List<Residente> listaResidente();
	public abstract Residente insertaActualizaResidente(Residente obj);

	
}

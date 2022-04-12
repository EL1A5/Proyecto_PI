package com.departamento.service;

import java.util.List;
import java.util.Optional;

import com.departamento.entity.Residente;
public interface ResidenteService {

	public abstract List<Residente> listaResidente();
	public abstract Residente insertaActualizaResidente(Residente obj);
	public abstract List<Residente> listaResidentePorDni(String dni);
	public abstract List<Residente> listaResidentePorDniDiferenteDelMismo(String dni, int idresidente);
	public abstract Optional<Residente> listaResidentePorId(int idresidente);
	public abstract void eliminaResidentePorId(int idresidente);
	
}

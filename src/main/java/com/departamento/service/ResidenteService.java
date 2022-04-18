package com.departamento.service;

import java.util.List;
import java.util.Optional;

import com.departamento.entity.Residente;
public interface ResidenteService {
	
	public List<Residente> listarResidentes();
    public abstract Residente insertaActualizaResidente(Residente obj);
	public abstract Residente ActualizaResidente(Residente obj);
    public abstract Optional<Residente> listaidResidentePorId(int idResidente);
	public abstract void eliminaidResidentePorId(int idResidente);
	/*
	public abstract List<Residente> listaResidentePorDni(String dni);
	public abstract List<Residente> listaResidentePorDniDiferenteDelMismo(String dni, int idResidente);
	public abstract Optional<Residente> listaResidentePorId(int idResidente);*/
	
	
	
	
	
}




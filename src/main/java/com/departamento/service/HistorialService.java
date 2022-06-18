package com.departamento.service;

import java.util.List;

import com.departamento.entity.Historial;
import com.departamento.entity.Insidencia;

public interface HistorialService {

	public abstract Historial insertaHistorial(Historial obj);
	public abstract List<Historial> listarHistorial(String filtro);

	public abstract List<Historial> listarHistorialPorEstado(int estado);
	
	public abstract Historial buscarPorId(int id);
}

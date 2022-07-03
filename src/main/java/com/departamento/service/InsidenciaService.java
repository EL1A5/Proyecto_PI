package com.departamento.service;

import java.util.List;

import com.departamento.entity.Insidencia;

public interface InsidenciaService {

	public abstract Insidencia insertaActualizaInsidencias(Insidencia obj);
	public abstract List<Insidencia> listarInsidencia(String filtro);

	public abstract List<Insidencia> listarInsidenciaPorEstado(String estado);
	
	public abstract Insidencia buscarPorId(int id);
	public abstract Insidencia buscarNumyEstado(String numdepa,String estado);

}

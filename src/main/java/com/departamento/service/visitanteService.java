package com.departamento.service;

import java.util.List;

import com.departamento.entity.visitante;

public interface visitanteService {
	public abstract visitante insertaActualizaVistante(visitante obj);
	public abstract List<visitante> listarVisitante();
	public  visitante buscarPorId(int id);
	public  void eliminar (int id);

}

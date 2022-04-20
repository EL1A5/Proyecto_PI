package com.departamento.service;

import java.util.List;

import com.departamento.entity.visitante;

public interface visitanteService {
	public visitante insertaActualizaVistante(visitante obj);
	public List<visitante> listarVisitante();
}

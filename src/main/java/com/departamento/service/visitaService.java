package com.departamento.service;

import java.util.List;

import com.departamento.entity.visita;

public interface visitaService {
	public visita insertaActualizaVistas(visita obj);
	public List<visita> listarVisitas();
}

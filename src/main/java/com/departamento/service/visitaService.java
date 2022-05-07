package com.departamento.service;

import java.util.List;

import com.departamento.entity.visita;
import com.departamento.entity.visitante;

public interface visitaService {
	public abstract visita insertaActualizaVistas(visita obj);
	public abstract List<visita> listarVisitas(String filtro);

	public abstract List<visita> listarVisitasPorEstado(String estado);
	public abstract visita buscarPorId(int id);
	public abstract void eliminar (int id);
	
}

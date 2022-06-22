package com.departamento.service;

import java.util.List;

import com.departamento.entity.Departamento;
import com.departamento.entity.Propietario;

public interface DepartamentoService {
	
	public List<Departamento> listarDptos();
	public void guardar(Departamento dpto);
	public Departamento buscarPorId(Integer id);
	public void eliminar (Integer id);
	public  Departamento buscarnumdepartamento(String numdepartamento);

}

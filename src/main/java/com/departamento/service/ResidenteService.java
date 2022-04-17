package com.departamento.service;

import java.util.List;
import java.util.Optional;

import com.departamento.entity.Residente;
public interface ResidenteService {

	
	public List<Residente> listarResidentes();
	public void guardar(Residente rsdte);
	public Residente buscarPorId(Integer id);
	public void eliminar (Integer id);

}


package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.visitante;
import com.departamento.repository.visitanteRepository;

@Service
public class visitanteServiceImpl implements visitanteService {

	@Autowired
	private visitanteRepository repositorio;

	@Override
	public visitante insertaActualizaVistante(visitante obj) {
		// TODO Auto-generated method stub
		return repositorio.save(obj);
	}

	@Override
	public List<visitante> listarVisitante() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public visitante buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		 repositorio.deleteById(id);
		
	}

	@Override
	public visitante buscarPorDni(int dni) {
		// TODO Auto-generated method stub
		return repositorio.findByDni(dni);
	}
	

}

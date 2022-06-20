package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Insidencia;
import com.departamento.repository.InsidenciaRepository;
@Service
public class InsidenciaServiceImpl implements InsidenciaService{

	@Autowired
	private InsidenciaRepository repository;
	@Override
	public Insidencia insertaActualizaInsidencias(Insidencia obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Insidencia> listarInsidencia(String filtro) {
		// TODO Auto-generated method stub
		return repository.findAll(filtro);
	}

	@Override
	public List<Insidencia> listarInsidenciaPorEstado(int estado) {
		// TODO Auto-generated method stub
		return repository.findByEstado(estado);
	}

	@Override
	public Insidencia buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Insidencia buscarNumyEstado(String numdepa, int estado) {
		// TODO Auto-generated method stub
		return repository.findAllParam(numdepa, estado);
	}

}

package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Historial;
import com.departamento.repository.HistorialRepository;

@Service
public class HistorialServiceImpl implements HistorialService{

	@Autowired
	private HistorialRepository repository;
	
	@Override
	public Historial insertaHistorial(Historial obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Historial> listarHistorial(String filtro) {
		// TODO Auto-generated method stub
		return repository.findAll(filtro);
	}

	@Override
	public List<Historial> listarHistorialPorEstado(int estado) {
		// TODO Auto-generated method stub
		return repository.findByEstado(estado);
	}

	@Override
	public Historial buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

}

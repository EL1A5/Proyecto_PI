package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.visita;
import com.departamento.repository.visitaRepository;
@Service
public class visitaServiceImpl implements visitaService {

	@Autowired
	private visitaRepository repository;
	@Override
	public visita insertaActualizaVistas(visita obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<visita> listarVisitas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}

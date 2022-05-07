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
		
		return repository.save(obj);
	}

	@Override
	public List<visita> listarVisitas(String filtro) {
		
		if (filtro!=null) {
			return repository.findAll(filtro);
		}
		return repository.findAll();
	}

	@Override
	public visita buscarPorId(int id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void eliminar(int id) {
		repository.deleteById(id);

	}

	@Override
	public List<visita> listarVisitasPorEstado(String estado) {
		// TODO Auto-generated method stub
		return repository.findByEstado(estado);
	}

	

}

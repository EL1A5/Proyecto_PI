package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Departamento;
import com.departamento.repository.DepartamentoRepository;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository dptoRepository;

	@Override
	public List<Departamento> listarDptos() {
		
		return dptoRepository.findAll();
	}

	@Override
	public void guardar(Departamento dpto) {
		dptoRepository.save(dpto);
		
	}

	@Override
	public Departamento buscarPorId(Integer id) {		
		return dptoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		dptoRepository.deleteById(id);
		
	}

	@Override
	public Departamento buscarnumdepartamento(String numdepartamento) {
		return dptoRepository.findBynumdepartamento(numdepartamento);
	}

}

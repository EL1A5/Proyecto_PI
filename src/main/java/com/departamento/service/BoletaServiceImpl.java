package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Boleta;
import com.departamento.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService {
	
	@Autowired
	private BoletaRepository boletaRepository;
	

	@Override
	public List<Boleta> listarBoletas() {
		return boletaRepository.findAll();
	}

	@Override
	public void guardar(Boleta boleta) {
		boletaRepository.save(boleta);
		
	}

	@Override
	public Boleta buscarPorId(Integer id) {
		return boletaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		boletaRepository.deleteById(id);
	}

}

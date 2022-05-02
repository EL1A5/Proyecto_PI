package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Mascota;

import com.departamento.repository.MascotaRepository;


@Service
public class MascotaServiceImpl implements MascotaService {

	@Autowired
	private MascotaRepository repository;

	@Override
	public List<Mascota> listarMascota() {
		return repository.findAll();
	}

	@Override
	public Mascota insertaActualizaMascota(Mascota obj) {
		return repository.save(obj);
	}


	@Override
	public Mascota buscarPorIdMascota(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);	
	}	


	

}




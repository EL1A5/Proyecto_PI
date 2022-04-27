package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Mascota;

import com.departamento.repository.MascotaRepository;


@Service
public class MascotaServiceImpl implements MascotaService {

	@Autowired
	private MascotaRepository repositorio;

	@Override
	public Mascota insertaActualizaMascota(Mascota obj) {
		// TODO Auto-generated method stub
		return repositorio.save(obj);
	}

	@Override
	public List<Mascota> listarMascota() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Mascota buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		 repositorio.deleteById(id);
		
	}
	

}




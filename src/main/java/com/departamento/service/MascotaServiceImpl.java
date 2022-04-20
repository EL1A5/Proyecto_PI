package com.departamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Mascota;
import com.departamento.repository.MascotaRepository;
@Service
public class MascotaServiceImpl  implements MascotaService{
	@Autowired
	private MascotaRepository repository;
	
	@Override
	public Mascota insertaMascota(Mascota obj) {
		
		return repository.save(obj);
	}

}

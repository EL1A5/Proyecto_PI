package com.departamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Residente;
import com.departamento.repository.ResidenteRepository;
@Service
public class ResidenteServiceImp implements ResidenteService{
	@Autowired
	private ResidenteRepository repository;
	
	@Override
	public List<Residente> listaResidente() {
		return repository.findAll();
	}
	@Override
	public Residente insertaActualizaResidente(Residente obj) {
		return repository.save(obj);
	
	}

}

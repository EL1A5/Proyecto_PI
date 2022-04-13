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

	@Override
	public List<Residente> listaResidentePorDni(String dni) {
		return repository.listaPorDni(dni);
	}

	@Override
	public List<Residente> listaResidentePorDniDiferenteDelMismo(String dni, int idresidente) {
		return repository.listaPorDniDiferenteSiMismo(dni, idresidente);
	}

	@Override
	public Optional<Residente> listaResidentePorId(int idresidente) {
		return repository.findById(idresidente);
		}
	@Override
	public void eliminaResidentePorId(int idresidente) {
		repository.deleteById(idresidente);
	}

}

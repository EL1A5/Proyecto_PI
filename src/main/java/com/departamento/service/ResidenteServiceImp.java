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
	public List<Residente> listarResidentes() {
		return repository.findAll();
	}

	@Override
	public Residente insertaActualizaResidente(Residente obj) {
		return repository.save(obj);
	}

	@Override
	public Residente ActualizaResidente(Residente obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Residente> listaidResidentePorId(int idResidente) {
		return repository.findById(idResidente);
	}

	@Override
	public void eliminaidResidentePorId(int idResidente) {
		repository.deleteById(idResidente);
		
	}
    //////////
	/*@Override
	public List<Residente> listaResidentePorDni(String dni) {
		return repository.listaResidentePorDni(dni);
	}

	@Override
	public List<Residente> listaResidentePorDniDiferenteDelMismo(String dni, int idResidente) {
		return repository.listaResidentePorDniDiferenteSiMismo(dni, idResidente);
	}
   
	@Override
	public Optional<Residente> listaResidentePorId(int idResidente) {
		return repository.findById(idResidente);
		} */


	
}
	
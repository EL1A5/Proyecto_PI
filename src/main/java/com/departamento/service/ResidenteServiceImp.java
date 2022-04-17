package com.departamento.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.departamento.entity.Residente;
import com.departamento.repository.ResidenteRepository;


@Service
public class ResidenteServiceImp implements ResidenteService{
	@Autowired
	private ResidenteRepository rsdteRepository;

	@Override
	public List<Residente> listarResidentes() {
		return rsdteRepository.findAll();
		}

	@Override
	public void guardar(Residente rsdte) {
		rsdteRepository.save(rsdte);
	}

	@Override
	public Residente buscarPorId(Integer id) {
		return rsdteRepository.findById(id).orElse(null);
		}


	@Override
	public void eliminar(Integer id) {
		rsdteRepository.deleteById(id);
		
	}

	}
	

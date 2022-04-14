package com.departamento.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.departamento.entity.Residente;
import com.departamento.repository.ResidenteRepository;
import com.departamento.util.AppSettings;
@Service
public class ResidenteServiceImp implements ResidenteService{
	
	@Autowired
	private ResidenteRepository repository;

	public List<Residente> listaResidente() {
		return repository.findAll();
	}

	@Override
	public Residente registraResidente(Residente obj) {
		return repository.save(obj);
		}

	@Override
	public Residente registraActualizaResidente(Residente obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminarPorIdResidente(int idResidente) {
		repository.deleteById(idResidente);
		
}

	}
	

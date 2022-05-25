package com.departamento.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.departamento.entity.Propietario;
import com.departamento.entity.Residente;
import com.departamento.entity.visitante;
import com.departamento.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements  PropietarioService {
	@Autowired
	private PropietarioRepository repository;

	@Override
	public List<Propietario> listarPropietarios() {
		return repository.findAll();
	}

	@Override
	public Propietario insertaActualizaPropietario(Propietario obj) {
		return repository.save(obj);
		}


	@Override
	public Propietario buscarPorIdPropietario(Integer id) {
		return repository.findById(id).orElse(null);
		}
	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
		}

	@Override
	public Propietario buscarPorDni(String dni) {
		return repository.findByDni(dni);
	}
	

}

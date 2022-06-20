package com.departamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Usuario;
import com.departamento.repository.UsuarioRepository;

@Service
public class UsuarioImpl implements UsuarioService{

	@Autowired
	
	UsuarioRepository repo;
	@Override
	public Usuario BuscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.findByUsername(nombre);
	}

}

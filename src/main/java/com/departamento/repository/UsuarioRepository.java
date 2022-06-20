package com.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departamento.entity.Usuario;
import com.departamento.entity.visita;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsername(String name);
}

package com.departamento.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.departamento.entity.*;

public interface PropietarioRepository extends JpaRepository<Propietario, Integer>  {
	  public Propietario findByDni(String dni);
	
}

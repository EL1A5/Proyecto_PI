package com.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.departamento.entity.visita;

public interface visitaRepository extends JpaRepository<visita, Integer>{

	
	  @Query("SELECT  v FROM visita v"+ 
	  "  join v.idvisitante vi " +
	  "  join v.residente r " +
	  "  join v.departamento d " +
	  "  join v.usuario u  WHERE concat(vi.nombre,vi.dni, r.nombre,d.numdepartamento,u.username,v.estado) like %?1%"
	  ) 
	  
	
	  public List<visita> findAll(String palabra);
	 

	  public List<visita> findByEstado(String estado);
}

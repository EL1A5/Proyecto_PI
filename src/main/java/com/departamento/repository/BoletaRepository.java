package com.departamento.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.departamento.entity.Boleta;
import com.departamento.entity.visita;

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
	
	@Query("SELECT  b FROM Boleta b"+ 
			  "  join b.servicio se " +
			  "  join b.propietario pr " +
			  " WHERE concat(se.nombreserv, pr.nombre,pr.apellidos,b.estado) like %?1%"
			  ) 
			  
			
			 public List<Boleta> findAll(String palabra);
			 
			  @Query("SELECT  b FROM Boleta b"+ 
					  "  join b.servicio se " +
					  "  join b.propietario pr " +
					  " WHERE pr.dni=?1 and b.estado=?2"
					  ) 
					  
					
			  public Boleta findAllParam(int dni,String estado);
			  
			  public List<Boleta> findByEstado(String estado);

}

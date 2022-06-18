package com.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.departamento.entity.Historial;

public interface HistorialRepository extends JpaRepository<Historial, Integer>{

			@Query("SELECT  v FROM Historial v"+ 
					 
			  
			  "  join v.departamento d " +
			  "  join v.usuario u  WHERE concat(v.descripcion,d.numdepartamento,u.username,v.estado) like %?1%"
			  )  
			  
			
			  public List<Historial> findAll(String filtro);
			 

			  public List<Historial> findByEstado(int estado);
}

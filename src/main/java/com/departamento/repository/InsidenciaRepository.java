package com.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.departamento.entity.Insidencia;
import com.departamento.entity.visita;

public interface InsidenciaRepository extends JpaRepository<Insidencia, Integer>{

			 @Query("SELECT  v FROM Insidencia v"+ 
					 
			  "  join v.residente r " +
			  "  join v.departamento d " +
			  "  join v.usuario u  WHERE concat(v.tipo, r.nombre,d.numdepartamento,u.username,v.estado) like %?1%"
			  )  
			  
			
			  public List<Insidencia> findAll(String palabra);
			 @Query("SELECT  v FROM Insidencia v"+ 
					  
					
					  "  join v.departamento d " +
					  "  join v.usuario u WHERE  d.numdepartamento=?1 and v.estado=?2"
					  ) 


			  public Insidencia findAllParam(String numdepa,int estado);

			  public List<Insidencia> findByEstado(int estado);
			  
			  
}

package com.departamento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.departamento.entity.Residente;

public interface ResidenteRepository extends JpaRepository<Residente, Integer>{
/*	@Query("select e from residente e where e.dni = ?1")
	public List<Residente> listaPorDni(String dni);
	
	@Query("select e from residente e where e.dni = ?1 and e.idresidente <> ?2")
	public List<Residente> listaPorDniDiferenteSiMismo(String dni, int idresidente);
*/
	

}

package com.departamento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.departamento.entity.Residente;

public interface ResidenteRepository extends JpaRepository<Residente, Integer>{


	/*@Query("select * from residente e where e.dni = ?")
	public List<Residente> listaResidentePorDni(String dni);
	
	@Query("select * from residente e where e.dni = ?1 and e.idresidente <> ?")
	public List<Residente> listaResidentePorDniDiferenteSiMismo(String dni, int idResidente);

   */
}



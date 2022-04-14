package com.departamento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.departamento.entity.Residente;

public interface ResidenteRepository extends JpaRepository<Residente, Integer>{
	
	@Query("Select a from residente a where nombre like :fil order by a.idresidente desc")
	public abstract List<Residente> listaResidentePorNombreLike(@Param("fil") String filtro);
	public abstract List<Residente> findByDni(String dni);
	public abstract List<Residente> findByDniAndIdResidenteo(String dni, int idResidente);
}



package com.departamento.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.departamento.entity.Residente;

public interface ResidenteRepository extends JpaRepository<Residente, Integer>{

}



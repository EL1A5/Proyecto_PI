package com.departamento.service;

import java.util.List;

import com.departamento.entity.Mascota;
import com.departamento.entity.Propietario;


public interface MascotaService {
	public List<Mascota> listarMascota();
    public abstract Mascota insertaActualizaMascota(Mascota obj);
	public Mascota buscarPorIdMascota(Integer id);
	public void eliminar (Integer id);
	
	

}




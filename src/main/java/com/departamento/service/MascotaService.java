package com.departamento.service;

import java.util.List;

import com.departamento.entity.Mascota;


public interface MascotaService {
	
	public abstract Mascota insertaActualizaMascota(Mascota obj);
	public abstract List<Mascota> listarMascota();
	public  Mascota buscarPorId(int id);
	public  void eliminar (int id);
	

}



package com.departamento.service;

import java.util.List;

import com.departamento.entity.Servicio;



public interface ServicioService {
	
	public List<Servicio> listarServicios();
	public void guardar(Servicio servicio);
	public Servicio buscarPorId(Integer id);
	public void eliminar (Integer id);
	//public  Servicio buscarNombreServicio(String nombreserv);

}

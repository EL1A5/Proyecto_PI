package com.departamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Departamento;
import com.departamento.entity.Servicio;
import com.departamento.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService{
	
	@Autowired
	private ServicioRepository servicioRepository;

	@Override
	public List<Servicio> listarServicios() {
		return servicioRepository.findAll();
	}

	@Override
	public void guardar(Servicio servicio) {
		servicioRepository.save(servicio);		
	}

	@Override
	public Servicio buscarPorId(Integer id) {
		return servicioRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		servicioRepository.deleteById(id);
	}


	/*@Override
	public Servicio buscarNombreServicio(String nombreserv) {
		return servicioRepository.findByNombreServicio(nombreserv);
	}*/

}

package com.departamento.service;

import java.util.Date;
import java.util.List;

import com.departamento.entity.Boleta;


public interface BoletaService {
	
	public List<Boleta> listarBoletas();
	public Boleta  guardar(Boleta boleta);
	public Boleta buscarPorId(Integer id);
	public void eliminar (Integer id);
	
	//public List<Date> listaFechaPago(int anio);

}

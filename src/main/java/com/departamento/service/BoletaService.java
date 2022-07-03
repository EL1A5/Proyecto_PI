package com.departamento.service;

import java.util.Date;
import java.util.List;

import com.departamento.entity.Boleta;
import com.departamento.entity.Servicio;


public interface BoletaService {
	
	public List<Boleta> listarBoletas();
	public Boleta  guardar(Boleta boleta);

	public void eliminar (Integer id);
	
	public abstract List<Boleta> listarBoletaPorEstado(String estado);
	public abstract Boleta buscarPorId(int id);
	public abstract Boleta buscarPorParametros(int dni,String param);
	public abstract List<Boleta> listarBoletasFiltro(String filtro);
	
	
	//Pago
	
	

	public void eliminarPago (Integer id);
	
	public abstract List<Boleta> listarBoletaPorEstadoPago(String estado);
	public abstract Boleta buscarPorIdPago(int id);
	public abstract Boleta buscarPorParametrosPago(int dni,String param);
	public abstract List<Boleta> listarBoletasFiltroPago(String filtro);
	
/////
	
	
	
	//public List<Date> listaFechaPago(int anio);

}

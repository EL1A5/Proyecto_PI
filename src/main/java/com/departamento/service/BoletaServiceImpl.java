package com.departamento.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.departamento.entity.Boleta;
import com.departamento.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService {

	@Autowired
	private BoletaRepository boletaRepository;

	@Override
	public List<Boleta> listarBoletas() {
		return boletaRepository.findAll();
	}

	@Override
	public Boleta guardar(Boleta boleta) {
		return boletaRepository.save(boleta);

	}

	@Override

	public void eliminar(Integer id) {
		boletaRepository.deleteById(id);
	}

	@Override
	public List<Boleta> listarBoletaPorEstado(String estado) {
		return boletaRepository.findByEstado(estado);
	}

	@Override
	public Boleta buscarPorId(int id) {
		return boletaRepository.findById(id).get();
	}

	@Override
	public Boleta buscarPorParametros(int dni, String param) {
		return boletaRepository.findAllParam(dni,param);
	}

	@Override
	public List<Boleta> listarBoletasFiltro(String filtro) {
		if (filtro!=null) {
			return boletaRepository.findAll(filtro);
		}
		return boletaRepository.findAll();

	}

	/*
	 * @Override public List<Date> listaFechaPago(int anio) { int[] ultimoDiasMes ={
	 * 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	 * 
	 * // En los años bisiestos el mes de febrero tiene 29 días if ((anio % 400 ==0)
	 * || (anio % 4 == 0 && anio % 100 != 0)) { ultimoDiasMes[1] = 29; }
	 * 
	 * ArrayList<Date> fechasPago = new ArrayList<Date>();
	 * 
	 * Calendar objCalendar = Calendar.getInstance(); for (int i = 0; i
	 * <ultimoDiasMes.length; i++) { objCalendar.set(Calendar.YEAR, anio);
	 * objCalendar.set(Calendar.MONTH, i);
	 * objCalendar.set(Calendar.DAY_OF_MONTH,ultimoDiasMes[i]);
	 * 
	 * // Si es sabado o domingo pagará el viernes se retrocede unos días
	 * if(objCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
	 * objCalendar.set(Calendar.DAY_OF_MONTH, ultimoDiasMes[i] - 1); } else
	 * if(objCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	 * objCalendar.set(Calendar.DAY_OF_MONTH, ultimoDiasMes[i] - 2); }
	 * 
	 * Date fechaCambiada = objCalendar.getTime(); fechasPago.add(fechaCambiada); }
	 * 
	 * return fechasPago; }
	 */

}

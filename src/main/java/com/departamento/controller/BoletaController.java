package com.departamento.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.departamento.entity.Boleta;
import com.departamento.entity.Departamento;
import com.departamento.entity.GeneracionFechas;
import com.departamento.entity.Propietario;
import com.departamento.entity.Servicio;
import com.departamento.service.BoletaService;
import com.departamento.service.PropietarioService;
import com.departamento.service.ServicioService;

@Controller
@RequestMapping("/views/Boleta")
public class BoletaController {

	@Autowired
	private BoletaService boletaservice;

	@Autowired
	private ServicioService servicioservice;

	@Autowired
	private PropietarioService propietarioservice;

	@Secured("ROLE_GERENTE")
	@GetMapping("/")

	public String listarBoletas(Model model, @Param("filtro") String filtro, @Param("estado") String estado) {
		
		List<Boleta> listadoBoletas;
		
		if ( filtro == "" || estado == "Pendiente" || estado == "Cancelado") {
			listadoBoletas = boletaservice.listarBoletaPorEstado(estado);
		} else {
			listadoBoletas = boletaservice.listarBoletasFiltro(filtro);
		}

		model.addAttribute("titulo", "Lista de Boletas");
		model.addAttribute("boletas", listadoBoletas);
		model.addAttribute("filtro", filtro);
		model.addAttribute("estado", estado);

		return "/views/Boleta/listar";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/registrar")
	public String registrar(Model model) {

		Boleta boleta = new Boleta();
		List<Servicio> servicio = servicioservice.listarServicios();
		List<Propietario> propietario = propietarioservice.listarPropietarios();

		model.addAttribute("boletas", boleta);
		model.addAttribute("servicios", servicio);
		model.addAttribute("propietarios", propietario);

		return "/views/Boleta/registrar";
	}
	
	
	
	
	
	
	
	
	

	@Secured("ROLE_GERENTE")
	@PostMapping("/save")
	public String guardar(@ModelAttribute Boleta boleta, Model model) {
		List<Servicio> servicio = servicioservice.listarServicios();
		List<Propietario> propietario = propietarioservice.listarPropietarios();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Date> lstfecha = GeneracionFechas.listaFechaPago(2022);

		
		model.addAttribute("boletas", boleta);
		model.addAttribute("servicios", servicio);
		model.addAttribute("propietarios", propietario);
		
		boleta.setEstado("Pendiente");
		//for (int i = 0; i < 12; i++) { 
			
			  //boleta.setFechaVenc(lstfecha.get(i));
			  boletaservice.guardar(boleta);
			 // System.out.println(boleta);
			 // }
		

		return "redirect:/views/Boleta/";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idBoleta) {

		Boleta boleta = boletaservice.buscarPorId(idBoleta);
		// boleta.setEstado("0");
		boletaservice.eliminar(idBoleta);

		return "redirect:/views/Boleta/";
	}

}

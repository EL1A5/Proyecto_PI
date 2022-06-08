package com.departamento.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.departamento.entity.Boleta;
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
	public String listarBoletas(Model model) {
		List<Boleta> listadoBoletas = boletaservice.listarBoletas();

		model.addAttribute("titulo", "Lista de Boletas");
		model.addAttribute("boletas", listadoBoletas);
		return "/views/Boleta/listar";
	}
	
	@Secured("ROLE_GERENTE")
	@GetMapping("/registrar")
	public String registrar(Model model) {

		Boleta boleta = new Boleta();
		List<Servicio> servicio = servicioservice.listarServicios();
		List<Propietario> propietario = propietarioservice.listarPropietarios();
		
		model.addAttribute("boleta", boleta);
		model.addAttribute("servicios", servicio);
		model.addAttribute("propietarios", propietario);

		return "/views/Boleta/registrar";
	}
	
	@Secured("ROLE_GERENTE")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Boleta boleta, BindingResult resul, Model model) {
		List<Servicio> servicio = servicioservice.listarServicios();
		List<Propietario> propietario = propietarioservice.listarPropietarios();
		
			model.addAttribute("boleta", boleta);
			
			model.addAttribute("servicios", servicio);
			model.addAttribute("propietarios", propietario);
			model.addAttribute("error", "servicio ya existe ,ingrese un servicio distinto al registrado en el sistema");
			System.out.println("Ingresar datos correctos");
			
		
		boleta.setEstado("Pendiente");
		boleta.setFechaEmision(new Date());
		boleta.setFechaVenc(null);

		boletaservice.guardar(boleta);

		return "redirect:/views/Boleta/";
	}

}

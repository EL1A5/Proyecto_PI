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

import com.departamento.entity.Departamento;
import com.departamento.entity.Propietario;
import com.departamento.entity.Servicio;
import com.departamento.service.DepartamentoService;
import com.departamento.service.ServicioService;

@Controller
@RequestMapping("/views/Servicio")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioservice;
	
	
	@Secured("ROLE_GERENTE")
	@GetMapping("/")
	public String listarServicios(Model model) {
		List<Servicio> listadoServicios = servicioservice.listarServicios();

		model.addAttribute("titulo", "Lista de Servicios");
		model.addAttribute("servicios", listadoServicios);
		return "/views/Servicio/listar";
	}
	
	@Secured("ROLE_GERENTE")
	@GetMapping("/registrar")
	public String registrar(Model model) {

		Servicio servicio = new Servicio();

		model.addAttribute("servicio", servicio);

		return "/views/Servicio/registrar";
	}
	
	@Secured("ROLE_GERENTE")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Servicio servicio, BindingResult resul, Model model) {
	
			model.addAttribute("servicio", servicio);
			
			model.addAttribute("error", "servicio ya existe ,ingrese un servicio distinto al registrado en el sistema");
			System.out.println("Ingresar datos correctos");
			
		
		servicio.setEstado(1);
		servicio.setFechareg(new Date());

		servicioservice.guardar(servicio);

		return "redirect:/views/Servicio/";
	}

}

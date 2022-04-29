package com.departamento.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.departamento.entity.visitante;
import com.departamento.service.visitanteService;

@Controller
@RequestMapping("/views/vistante")
public class VisitanteController {

	@Autowired
	private visitanteService service;

	

	
	@Secured("ROLE_USER")
	@GetMapping("/")
	public String ListarVisitantes(Model model) {
		List<visitante> lista = service.listarVisitante();
		
		
		
		model.addAttribute("titulo", "visitante");
		model.addAttribute("visitante", lista);
		return "/views/vistante/listar";
	}

	
	@Secured("ROLE_USER")
	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {

		visitante visitante = new visitante();
		
		model.addAttribute("visitante", visitante);

		return "/views/vistante/registrar";
	}
	

	@Secured("ROLE_USER")
	@PostMapping("/save")
	public String Guardar(@ModelAttribute visitante obj) {
		

		
		obj.setActivo(1);
		obj.setFechareg(new Date());
		service.insertaActualizaVistante(obj);
		return "redirect:/views/vistante/";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer id ,Model model) {
		
		visitante vist = service.buscarPorId(id);
		
		
		model.addAttribute("visitante", vist);
		
		return "/views/vistante/registrar";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer id) {
		
		visitante visit=service.buscarPorId(id);
		visit.setActivo(0);
		service.insertaActualizaVistante(visit);
		return "redirect:/views/vistante/";
	}

	
	
}

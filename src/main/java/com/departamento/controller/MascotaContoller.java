package com.departamento.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.departamento.entity.Mascota;
import com.departamento.entity.Residente;
import com.departamento.service.MascotaService;


@Controller
@RequestMapping("/views/Mascota")
public class MascotaContoller {

	@Autowired
	private MascotaService mascotaservice;
	
	@Secured("ROLE_GERENTE")
	@GetMapping("/")
	public String listamacotas(Model model) {
		List<Mascota> lstmascotas = mascotaservice.listarMascota();
		
		model.addAttribute("titulo","Lista de Mascotas");
		model.addAttribute("mascota",lstmascotas );
		return "/views/Mascota/listar";
	}
	@Secured("ROLE_GERENTE")
	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		Mascota mascota = new Mascota();
		model.addAttribute("mascota", mascota);
		
		return "/views/Mascota/registrar";
	}
	@Secured("ROLE_GERENTE")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Mascota masoc,BindingResult resul, Model model) {
		if (resul.hasErrors()) 
		{
			model.addAttribute("mascota", masoc);
			System.out.println("Ingresar datos correctos");
			return "/views/Mascota/registrar";
		}
		masoc.setFechareg(new Date());
		masoc.setEstado(1);
		
		mascotaservice.insertaActualizaMascota(masoc);
		System.out.println("Mascota guardado Exitosamente");
		return "redirect:/views/Mascota/";
	}
	@Secured("ROLE_GERENTE")
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idMascota ,Model model) {
		
		Mascota mascota = mascotaservice.buscarPorIdMascota(idMascota);
		
		model.addAttribute("mascota", mascota);
		
		return "/views/Mascota/registrar";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idMascota) {
		Mascota mascota=mascotaservice.buscarPorIdMascota(idMascota);
		mascota.setEstado(0);
		mascotaservice.insertaActualizaMascota(mascota);
		return "redirect:/views/Mascota/";
	}


}


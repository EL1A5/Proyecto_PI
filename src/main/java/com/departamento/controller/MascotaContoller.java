package com.departamento.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.departamento.entity.Mascota;
import com.departamento.entity.Residente;
import com.departamento.service.MascotaService;


@Controller
@RequestMapping("/views/Mascota")
public class MascotaContoller {

	@Autowired
	private MascotaService mascotaservice;
	@GetMapping("/")
	public String listamacotas(Model model) {
		List<Mascota> lstmascotas = mascotaservice.listarMascota();
		
		model.addAttribute("titulo","Lista de Mascotas");
		model.addAttribute("mascota",lstmascotas );
		return "/views/Mascota/listar";
	}
	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		Mascota mascota = new Mascota();
		model.addAttribute("mascota", mascota);
		
		return "/views/Mascota/registrar";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Mascota mascota) {
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Date fecha = new Date(dtf4.format(LocalDateTime.now()));
		
		mascota.setFechareg(fecha);
		mascota.setEstado(1);
		
		mascotaservice.insertaActualizaMascota(mascota);
		System.out.println("Mascota guardado Exitosamente");
		return "redirect:/views/Mascota/";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idMascota ,Model model) {
		
		Mascota mascota = mascotaservice.buscarPorIdMascota(idMascota);
		
		model.addAttribute("mascota", mascota);
		
		return "/views/Mascota/registrar";
	}
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idMascota) {
		mascotaservice.eliminar(idMascota);
		System.out.println("Mascota eliminado exitosamente");
		return "redirect:/views/Mascota/";
	}


}


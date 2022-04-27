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

import com.departamento.service.MascotaService;


@Controller
@RequestMapping("/views/mascota")
public class RegistroMascotaContoller {

	@Autowired
	private MascotaService service;
	
	@GetMapping("/")
	public String ListarMascotas(Model model) {
		List<Mascota> lista = service.listarMascota();
		
		model.addAttribute("titulo" , "mascota");
		model.addAttribute("mascota" , lista);
		return "/views/mascota/listar";
	}
	
	
	
	@GetMapping("/registrar")
	public String RegistrarMascota(Model model) {

		Mascota mascota = new Mascota();
		
		model.addAttribute("mascota", mascota);

		return "/views/mascota/registrar";
	}

	@PostMapping("/save")
	public String Guardar(@ModelAttribute Mascota obj) {
		

		
		obj.setActivo(1);
		obj.setFechareg(new Date());
		service.insertaActualizaMascota(obj);
		return "redirect:/views/mascota/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer id ,Model model) {
		
		Mascota vist = service.buscarPorId(id);
		
		
		model.addAttribute("mascota", vist);
		
		return "/views/mascota/registrar";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") int id) {
		
		service.eliminar(id);
		
		return "redirect:/views/mascota/";
	}
	
}


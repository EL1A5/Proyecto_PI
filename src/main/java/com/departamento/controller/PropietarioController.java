package com.departamento.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.departamento.entity.Propietario;
import com.departamento.entity.Residente;
import com.departamento.entity.visitante;
import com.departamento.service.PropietarioService;
import com.departamento.service.ResidenteService;

@Controller
@RequestMapping("/views/Propietario/")
public class PropietarioController {
	@Autowired
	private PropietarioService propietarioService;
	
	@GetMapping("/")
	public String listarpropietarios(Model model) {
		List<Propietario> lstprop = propietarioService.listarPropietarios();
		
		model.addAttribute("titulo","Lista de propietarios");
		model.addAttribute("propietario",lstprop );
		return "/views/Propietario/listar";
	}

	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		Propietario propietario = new Propietario();
		model.addAttribute("propietario", propietario);
		
		return "/views/Propietario/registrar";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Propietario propietario) {
		
		
		
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Date fecha = new Date(dtf4.format(LocalDateTime.now()));
		
		propietario.setFechaReg(fecha);
		propietario.setEstado(1);
		
		propietarioService.insertaActualizaPropietario(propietario);
		System.out.println("Propietario guardado Exitosamente");
		return "redirect:/views/Propietario/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idPropietario ,Model model) {
		
		Propietario propietario = propietarioService.buscarPorIdPropietario(idPropietario);
		
		model.addAttribute("propietario", propietario);
		
		return "/views/propietario/registrar";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idPropietario) {
		
		propietarioService.eliminar(idPropietario);
		System.out.println("Propietario eliminado exitosamente");
		
		return "redirect:/views/Propietario/";
	}


}


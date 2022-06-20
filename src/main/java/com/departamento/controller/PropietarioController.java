package com.departamento.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	@Secured("ROLE_GERENTE")
	@GetMapping("/")
	public String listarpropietarios(Model model) {
		List<Propietario> lstprop = propietarioService.listarPropietarios();
		
		model.addAttribute("titulo","Lista de propietarios");
		model.addAttribute("propietario",lstprop );
		return "/views/Propietario/listar";
	}
	@Secured("ROLE_GERENTE")
	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		Propietario propietario = new Propietario();
		model.addAttribute("propietario", propietario);
		
		return "/views/Propietario/registrar";
	}
	@Secured("ROLE_GERENTE")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Propietario propietario,BindingResult resul, Model model) {
		Propietario dniyaexiste=propietarioService.buscarPorDni(propietario.getDni());
		Propietario nuevo = propietarioService.buscarPorIdPropietario(propietario.getIdPropietario());
		  
		if (nuevo==null &&dniyaexiste!=null ) 
		{
			model.addAttribute("propietario", propietario);
			model.addAttribute("error", "Propietario ya existe ,ingrese un numero de dni distinto al registrado en el sistema");
			System.out.println("Ingresar datos correctos");
			return "/views/Propietario/registrar";
		}
		
		
		propietario.setEstado(1);
		propietario.setFechaReg(new Date());
		
		propietarioService.insertaActualizaPropietario(propietario);
		
		return "redirect:/views/Propietario/";
	}
	@Secured("ROLE_GERENTE")
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idPropietario ,Model model) {
		
		Propietario propietario = propietarioService.buscarPorIdPropietario(idPropietario);
		
		
		model.addAttribute("propietario", propietario);
		
		return "/views/propietario/registrar";
	}
	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idPropietario) {
		
		Propietario propietario=propietarioService.buscarPorIdPropietario(idPropietario);
		propietario.setEstado(0);
		propietarioService.insertaActualizaPropietario(propietario);
		
		return "redirect:/views/Propietario/";
	}


}


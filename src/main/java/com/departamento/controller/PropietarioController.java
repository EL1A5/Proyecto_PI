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
@RequestMapping("/views/propietario")
public class PropietarioController {
	
	@Autowired
	private PropietarioService service;
	
	@Autowired
	private ResidenteService residenteService;


	
	@GetMapping("/listar")
	public String listarPropietarios(Model model) {
		List<Propietario> lista = service.listaPropietario();
		
		model.addAttribute("titulo", "Lista de propietarios");
		model.addAttribute("propietario", lista);
	
		return "/views/propietario/listar";
	}
	
	@GetMapping("/")
	public String RegistrarPropietario(Model model) {

		Propietario propietario = new Propietario();
		List<Residente> listaResidentes = residenteService.listarResidentes();
		
		model.addAttribute("titulo", "Registrar Propietario");
		model.addAttribute("propietario", propietario);
		model.addAttribute("residentes", listaResidentes);

		return "/views/propietario/registrar";
	}

	@PostMapping("/save")
	public String Guardar(@ModelAttribute Propietario obj) {
		obj.getIdresidente();
		service.GuardarPropietario(obj);
		return "redirect:/views/propietario/";
	}
	
	/*
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Propietario>> listaPropietario(){
		List<Propietario> lista = service.listaPropietario();
		return ResponseEntity.ok(lista);
	}
	
	//@GetMapping("/CrearPropietario")
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> GuardarPropietario(@RequestBody Propietario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Propietario objSalida = service.GuardarPropietario(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Comprueve que todos los campos esten llenados.");
			}else {
				salida.put("mensaje", "Propietario registrado.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "El residente con el ID " + obj.getIdresidente() + " no existe");
		}
		return ResponseEntity.ok(salida);
	}
	*/

}

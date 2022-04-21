package com.departamento.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.departamento.entity.Propietario;
import com.departamento.service.PropietarioService;

@Controller
@RequestMapping("/rest/propietario")
public class PropietarioController {
	
	@Autowired
	private PropietarioService service;

	/*
	@GetMapping("/")
	public String listarPropietarios(Model model) {
		List<Propietario> lista = service.listaPropietario();
		
		model.addAttribute("titulo", "Lista de Propietarios");
		model.addAttribute("propietario", lista);
	
		return "/rest/propietario/ListarPropietario";
	}
	*/
	
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

}

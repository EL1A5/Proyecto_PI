package com.departamento.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.departamento.entity.visitante;
import com.departamento.service.visitanteService;
@Controller
@RequestMapping("/views/visitante")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitanteController {
	
	@Autowired
	private visitanteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<visitante>> listaVisitante(){
		List<visitante> lista = service.listarVisitante();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaVisitante(@RequestBody visitante obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			visitante objSalida = service.insertaActualizaVistante(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("mensaje", "Se registró correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}

}

package com.departamento.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.departamento.entity.Residente;
import com.departamento.service.ResidenteService;
@RestController
@RequestMapping("/rest/residente")
public class ResidenteController {
	@Autowired
	private ResidenteService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Residente>> listaResidente() {
		List<Residente> lista = service.listaResidente();
		return ResponseEntity.ok(lista);
	
	}
}


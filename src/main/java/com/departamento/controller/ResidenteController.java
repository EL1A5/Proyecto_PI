package com.departamento.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.departamento.entity.Departamento;

import com.departamento.entity.Residente;
import com.departamento.service.DepartamentoService;
import com.departamento.service.ResidenteService;



@Controller
@RequestMapping("/views/Residente/")
/*
@RestController
@RequestMapping("/rest/residentes")*/
@CrossOrigin(origins = "http://localhost:4200")

public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;
	
	
	@GetMapping("/")
	public String listarresidentes(Model model) {
		List<Residente> lstresidentes = residenteService.listarResidentes();
		
		model.addAttribute("titulo","Lista de residentes");
		model.addAttribute("residente",lstresidentes );
		return "/views/Residente/listar";
	}

	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		Residente residente = new Residente();
		model.addAttribute("residente", residente);
		
		return "/views/Residente/registrar";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Residente residente) {
		
		
		
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Date fecha = new Date(dtf4.format(LocalDateTime.now()));
		
		residente.setFechaReg(fecha);
		residente.setActivo(1);
		residenteService.insertaActualizaResidente(residente);
		System.out.println("Residente guardado Exitosamente");
		return "redirect:/views/Residente/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idResidente ,Model model) {
		
		Residente residente = residenteService.buscarPorIdResidente(idResidente);
		
		model.addAttribute("residente", residente);
		
		return "/views/residente/registrar";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idResidente) {
		
		residenteService.eliminar(idResidente);
		System.out.println("Residente eliminado exitosamente");
		
		return "redirect:/views/Residente/";
	}
    @PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registraResidente(@RequestBody Residente obj) {
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			
			obj.setIdResidente(0);
			Residente objSalida = residenteService.insertaActualizaResidente(obj);
			
				if (objSalida == null) {
					salida.put("mensaje", "Error en el registro ");
				} else {
					salida.put("mensaje", "Registro exitoso");   }
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en el registro " + e.getMessage());
		}
		return ResponseEntity.ok(salida);

	}

}


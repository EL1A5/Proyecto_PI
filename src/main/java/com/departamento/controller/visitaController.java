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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.departamento.entity.visita;
import com.departamento.entity.visitante;
import com.departamento.service.visitaService;
import com.departamento.service.visitanteService;


@Controller
@RequestMapping("/views/visita")

public class visitaController {

	@Autowired
	private visitaService service;
	@Autowired
	private visitanteService visitanteservice;
	
	@GetMapping("/")
	public String ListarVisita(Model model) {
		List<visita> lista = service.listarVisitas();

		model.addAttribute("titulo", "visitante");
		model.addAttribute("visita", lista);
		return "/views/visita/listar";
	}

	

	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {

		visita visita = new visita();
		List<visitante>listvisitante=visitanteservice.listarVisitante();
		
		model.addAttribute("titulo", "Registrar Visitante");
		model.addAttribute("visita", visita);
		model.addAttribute("visitante", listvisitante);

		return "/views/visita/registrar";
	}

	@PostMapping("/save")
	public String Guardar(@ModelAttribute visita obj) {
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Date fecha = new Date(dtf4.format(LocalDateTime.now()));

		obj.setHoraentrada(fecha);
		obj.setHorasalida(fecha);
		service.insertaActualizaVistas(obj);
		return "redirect:/views/visita/";
	}
	
	
	/*
	 * @GetMapping
	 * 
	 * @ResponseBody public ResponseEntity<List<visita>> listaVisita(){ List<visita>
	 * lista = service.listarVisitas(); return ResponseEntity.ok(lista); }
	 * 
	 * 
	 * @PostMapping
	 * 
	 * @ResponseBody public ResponseEntity<Map<String, Object>>
	 * insertaVisitante(@RequestBody visita obj){ Map<String, Object> salida = new
	 * HashMap<>(); try { visita objSalida = service.insertaActualizaVistas(obj); if
	 * (objSalida == null) { salida.put("mensaje",
	 * "No se registró, consulte con el administrador."); }else {
	 * salida.put("mensaje", "Se registró correctamente."); } } catch (Exception e)
	 * { e.printStackTrace(); salida.put("mensaje",
	 * "No se registró, consulte con el administrador."); } return
	 * ResponseEntity.ok(salida); }
	 */
}

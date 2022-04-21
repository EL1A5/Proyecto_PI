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

import com.departamento.entity.visitante;
import com.departamento.service.visitanteService;

@Controller
@RequestMapping("/views/vistante")
public class VisitanteController {

	@Autowired
	private visitanteService service;

	
	
	/*
	 * @GetMapping
	 * 
	 * @ResponseBody public ResponseEntity<List<visitante>> listaVisitante(){
	 * List<visitante> lista = service.listarVisitante(); return
	 * ResponseEntity.ok(lista); }
	 */
	
	
	@GetMapping("/")
	public String ListarVisitantes(Model model) {
		List<visitante> lista = service.listarVisitante();

		model.addAttribute("titulo", "visitante");
		model.addAttribute("visitante", lista);
		return "/views/vistante/listar";
	}

	

	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {

		visitante visitante = new visitante();
		model.addAttribute("titulo", "Registrar Visitante");
		model.addAttribute("visitante", visitante);

		return "/views/vistante/registrar";
	}

	@PostMapping("/save")
	public String Guardar(@ModelAttribute visitante obj) {
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Date fecha = new Date(dtf4.format(LocalDateTime.now()));

		obj.setActivo(1);
		obj.setFechareg(fecha);
		service.insertaActualizaVistante(obj);
		return "redirect:/views/vistante/";
	}

	/*
	 * @PostMapping
	 * 
	 * @ResponseBody public ResponseEntity<Map<String, Object>>
	 * insertaVisitante(@RequestBody visitante obj) {
	 * 
	 * Map<String, Object> salida = new HashMap<>(); try { visitante objSalida =
	 * service.insertaActualizaVistante(obj); if (objSalida == null) {
	 * salida.put("mensaje", "No se registró, consulte con el administrador."); }
	 * else { salida.put("mensaje", "Se registró correctamente."); } } catch
	 * (Exception e) { e.printStackTrace(); salida.put("mensaje",
	 * "No se registró, consulte con el administrador."); } return
	 * ResponseEntity.ok(salida); }
	 */

}

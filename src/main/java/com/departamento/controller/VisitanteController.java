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

import com.departamento.entity.visitante;
import com.departamento.service.visitanteService;

@Controller
@RequestMapping("/views/vistante")
public class VisitanteController {

	@Autowired
	private visitanteService service;

	

	
	
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
		
		model.addAttribute("visitante", visitante);

		return "/views/vistante/registrar";
	}

	@PostMapping("/save")
	public String Guardar(@ModelAttribute visitante obj) {
		

		obj.setActivo(1);
		obj.setFechareg(new Date());
		service.insertaActualizaVistante(obj);
		return "redirect:/views/vistante/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer id ,Model model) {
		
		visitante vist = service.buscarPorId(id);
		
		
		model.addAttribute("visitante", vist);
		
		return "/views/vistante/registrar";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") int id) {
		
		service.eliminar(id);
		
		return "redirect:/views/vistante/";
	}

	
	/*
	 * @DeleteMapping("/{id}")
	 * 
	 * @ResponseBody
	 * 
	 * public ResponseEntity<HashMap<String, Object>> EliminaAlumno(@PathVariable
	 * int id){ HashMap<String, Object> salida = new HashMap<String, Object>(); try
	 * { Optional optional=service.buscarPorId(id);
	 * 
	 * if (optional.isPresent()) { service.eliminaPorId(id); salida.put("mensaje",
	 * "eliminacion exitosa"); } else { salida.put("mensaje",
	 * "No existe el ID : "+id); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); salida.put("mensaje",
	 * "Error en el registro " + e.getMessage()); } return
	 * ResponseEntity.ok(salida);
	 * 
	 * }
	 */
}

package com.departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.departamento.entity.Historial;
import com.departamento.entity.Insidencia;
import com.departamento.service.HistorialService;
import com.departamento.service.InsidenciaService;

@Controller
@RequestMapping("/views/historial")
public class HistorialController {

	@Autowired
	private HistorialService service;
	
	
	@Secured("ROLE_USER")
	@GetMapping("/")
	public String ListarHistorial(Model model, @Param("filtro") String filtro) {

		List<Historial> lista;
		int estado;
		if (filtro == "atendido" ) {
			 estado=0;
			lista = service.listarHistorialPorEstado(estado);
		} else if(filtro == "no atendido" ){
			estado=1;
			lista = service.listarHistorialPorEstado(estado);
		}else {
			lista = service.listarHistorial(filtro);
		}

		model.addAttribute("titulo", "Historial");
		model.addAttribute("historial", lista);
		model.addAttribute("filtro", filtro);
		
		return "/views/historial/listar";
	}
	
}

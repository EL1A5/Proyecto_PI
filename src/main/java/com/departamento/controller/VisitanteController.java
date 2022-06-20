package com.departamento.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.departamento.entity.Usuario;
import com.departamento.entity.visitante;
import com.departamento.service.UsuarioService;
import com.departamento.service.visitanteService;

@Controller
@RequestMapping("/views/vistante")
public class VisitanteController {

	@Autowired
	private visitanteService service;

	@Autowired
	private UsuarioService serviceusu;

	
	@Secured("ROLE_USER")
	@GetMapping("/")
	public String ListarVisitantes(Model model) {
		List<visitante> lista = service.listarVisitante();

		model.addAttribute("titulo", "visitante");
		model.addAttribute("visitante", lista);
		return "/views/vistante/listar";
	}

	
	@Secured("ROLE_USER")
	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {

		visitante visitante = new visitante();
		model.addAttribute("visitante", visitante);

		return "/views/vistante/registrar";
	}
	

	@Secured("ROLE_USER")
	@PostMapping("/save")
	public String Guardar(@Valid @ModelAttribute visitante obj,BindingResult resul, Model model) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
	    Usuario usuario=serviceusu.BuscarPorNombre(userName);
	    
	    
	    visitante dniyaexiste=service.buscarPorDni(obj.getDni());
	    visitante vistitantenuevo = service.buscarPorId(obj.getIdvisitante());
	    
		if (vistitantenuevo==null && dniyaexiste!=null ) 
		{
			model.addAttribute("visitante", obj);
			model.addAttribute("error", "VISITANTE YA EXISTE");
			return "/views/vistante/registrar";
		}
		
		
		obj.setActivo(1);
		obj.setFechareg(new Date());
		obj.setUsuario(usuario);
		service.insertaActualizaVistante(obj);
		return "redirect:/views/vistante/";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer id ,Model model) {
		
		visitante vist = service.buscarPorId(id);
		
		
		model.addAttribute("visitante", vist);
		
		return "/views/vistante/registrar";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer id) {
		
		visitante visit=service.buscarPorId(id);
		visit.setActivo(0);
		service.insertaActualizaVistante(visit);
		return "redirect:/views/vistante/";
	}

	
	
}

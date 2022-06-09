package com.departamento.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.departamento.entity.Departamento;
import com.departamento.entity.Residente;
import com.departamento.entity.Usuario;
import com.departamento.entity.visita;
import com.departamento.entity.visitante;
import com.departamento.service.DepartamentoService;
import com.departamento.service.ResidenteService;
import com.departamento.service.UsuarioService;
import com.departamento.service.visitaService;
import com.departamento.service.visitanteService;

@Controller
@RequestMapping("/views/visita")

public class visitaController {

	@Autowired
	private visitaService service;
	@Autowired
	private visitanteService visitanteservice;
	@Autowired
	private ResidenteService residenteservice;
	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private UsuarioService serviceusu;

	@Secured("ROLE_USER")
	@GetMapping("/")
	public String ListarVisita(Model model, @Param("filtro") String filtro, @Param("estado") String estado) {

		List<visita> lista;

		if (estado == "NoSalio" || estado == "Salio" || filtro == "") {
			lista = service.listarVisitasPorEstado(estado);
		} else {
			lista = service.listarVisitas(filtro);
		}

		model.addAttribute("titulo", "Gestion de Visitas");
		model.addAttribute("visita", lista);
		model.addAttribute("filtro", filtro);
		model.addAttribute("estado", estado);
		return "/views/visita/listar";
	}

	@Secured("ROLE_USER")
	@GetMapping("/registrar")
	public String RegistrarVisita(Model model, @Param("dni") String dni) {
		
		visita visita = new visita();

		visitante visitante = null;
		List<Residente> lstresidentes = residenteservice.listarResidentes();
		if (dni != null) {
			int dnis = Integer.parseInt(dni);
			System.out.println("EL DNI : " + dnis);
			visitante = visitanteservice.buscarPorDni(dnis);

			System.out.println("el visitante : " + visitante);
		}
		System.out.println("el visitante : " + visitante);
		model.addAttribute("titulo", "Registrar Visita");
		model.addAttribute("visita", visita);
		model.addAttribute("visitantes", visitante);

		model.addAttribute("residentes", lstresidentes);

		return "/views/visita/registrar";
	}

	@Secured("ROLE_USER")
	@PostMapping("/save")
	public String Guardar(@Valid @ModelAttribute visita obj, BindingResult resul, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		Usuario usuario = serviceusu.BuscarPorNombre(userName);

		Departamento departamento = departamentoService
				.buscarPorId(obj.getResidente().getDepartamento().getIddepartamento());
		obj.setDepartamento(departamento);
		obj.setEstado("NoSalio");
		obj.setHoraentrada(new Date());
		obj.setHorasalida(null);
		obj.setUsuario(usuario);
		System.out.println("EL VISITA:" + obj.getHoraentrada() + " salida " + obj.getHorasalida());
		if (resul.hasErrors()) {
			model.addAttribute("visitante", obj);
			model.addAttribute("error", "DNI ya ingresado");
			System.out.println("Ingresar datos correctos");
			return "/views/visita/registrar";
		}
		service.insertaActualizaVistas(obj);

		return "redirect:/views/visita/";
	}

	@Secured("ROLE_USER")
	@GetMapping("/salir/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {

		visita vist = service.buscarPorId(id);

		
		model.addAttribute("visita", vist);
		
		System.out.println("EL VISITA QUE SALIR: "+vist);

		return "/views/visita/salir";
	}
	@Secured("ROLE_USER")
	@PostMapping("/salir")
	public String salir(@Valid @ModelAttribute visita obj, BindingResult resul, Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		Usuario usuario = serviceusu.BuscarPorNombre(userName);

		visita visitsalir=service.buscarPorId(obj.getIdvisita());
		visitsalir.setHorasalida(new Date());
		visitsalir.setObservacion(obj.getObservacion());
		visitsalir.setEstado("Salio");
		visitsalir.setUsuario(usuario);
		System.out.println("EL VISITANTE QUE SALIO!!!!!!!!: "+ visitsalir);
		
		service.insertaActualizaVistas(visitsalir);
		
		return "redirect:/views/visita/";
	}
}

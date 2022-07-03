package com.departamento.controller;

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
import com.departamento.entity.Historial;
import com.departamento.entity.Insidencia;
import com.departamento.entity.Mascota;
import com.departamento.entity.Residente;
import com.departamento.entity.Usuario;
import com.departamento.entity.visita;
import com.departamento.entity.visitante;
import com.departamento.service.DepartamentoService;
import com.departamento.service.HistorialService;
import com.departamento.service.InsidenciaService;
import com.departamento.service.ResidenteService;
import com.departamento.service.UsuarioService;
import com.departamento.service.visitaService;
import com.departamento.service.visitanteService;

@Controller
@RequestMapping("/views/insidencia")
public class InsidenciaController {

	
	@Autowired
	private InsidenciaService service;
	@Autowired
	private ResidenteService residenteservice;
	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private UsuarioService serviceusu;
	
	@Autowired
	private HistorialService servicehis;
	
	@Secured("ROLE_USER")
	@GetMapping("/")
	public String ListarInsidencia(Model model, @Param("filtro") String filtro, @Param("estado") String estado) {

		List<Insidencia> lista;
		if ( filtro == "" || estado == "NoAtendido" || estado == "Atendido") {
			lista = service.listarInsidenciaPorEstado(estado);
		} else {
			lista = service.listarInsidencia(filtro);
		}


		model.addAttribute("titulo", "Gestion de Insidencias");
		model.addAttribute("insidencia", lista);
		model.addAttribute("filtro", filtro);
		
		return "/views/insidencia/listar";
	}

	@Secured("ROLE_USER")
	@GetMapping("/registrar")
	public String RegistrarInsidencia(Model model) {

		Insidencia insidencia = new Insidencia();

		List<Residente> lstresidentes = residenteservice.listarResidentes();
		
		
		model.addAttribute("insidencias", insidencia);
		model.addAttribute("residentes", lstresidentes);
		return "/views/insidencia/registrar";
		
	}
	
	
	
	@Secured("ROLE_USER")
	@PostMapping("/save")
	public String Guardar(@Valid @ModelAttribute Insidencia obj, BindingResult resul, Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		Usuario usuario = serviceusu.BuscarPorNombre(userName);

		//REGISTRAR INSIDENCIA
		List<Residente> lstresidentes = residenteservice.listarResidentes();
		Insidencia existe=service.buscarNumyEstado(obj.getDepartamento().getNumdepartamento(),"NoAtendido");

		if ( existe!=null ) {

			model.addAttribute("error", "departamento ya registrado");

			
			model.addAttribute("residentes", lstresidentes);
			return "/views/visita/registrar";
		}
		
		Departamento departamento = departamentoService
				.buscarPorId(obj.getResidente().getDepartamento().getIddepartamento());
		
		obj.setDepartamento(departamento);
		obj.setEstado("NoAtendido");
		obj.setFechareg(new Date());

		obj.setUsuario(usuario);
		
		
		//REGISTRAR HISTORIAL
		
		Historial objhis=new Historial();
		objhis.setInsidencia(obj);
		objhis.setUsuario(usuario);
		objhis.setDepartamento(departamento);
		objhis.setDescripcion("Nueva Insidencia de: "+obj.getResidente().getNombre()+" - " +obj.getResidente().getApellidos());
		objhis.setEstado(0);
		objhis.setFechareg(new Date());
		
		servicehis.insertaHistorial(objhis);
		service.insertaActualizaInsidencias(obj);

		return "redirect:/views/insidencia/";
	}
	
	
	//RESOLVER LA INSIDENCIA
	
	
	@Secured("ROLE_USER")
	@GetMapping("/actializar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {

		Insidencia insidencia = service.buscarPorId(id);

		
		model.addAttribute("insidencias", insidencia);
		
		System.out.println("EL VISITA QUE SALIR: "+insidencia);

		return "/views/visita/actualizar";
	}
	
	
	
	@Secured("ROLE_USER")
	@PostMapping("/actualizar")
	public String salir(@Valid @ModelAttribute Insidencia obj, BindingResult resul, Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		Usuario usuario = serviceusu.BuscarPorNombre(userName);

		Insidencia insidenciaResuelto=service.buscarPorId(obj.getIdincidencia());
		insidenciaResuelto.setFechaatencion(new Date());
		insidenciaResuelto.setEstado(obj.getEstado());
		insidenciaResuelto.setUsuario(usuario);
		
		System.out.println("EL VISITANTE QUE SALIO!!!!!!!!: "+ insidenciaResuelto);
		
		
		//REGISTRAR HISTORIAL
		
				Historial objhis=new Historial();
				objhis.setInsidencia(obj);
				objhis.setUsuario(usuario);
				objhis.setDepartamento(insidenciaResuelto.getDepartamento());
				objhis.setDescripcion("Resuelto la Insidencia de: "+obj.getResidente().getNombre()+" - " +obj.getResidente().getApellidos());
				objhis.setEstado(0);
				objhis.setFechareg(new Date());
				
				servicehis.insertaHistorial(objhis);
		service.insertaActualizaInsidencias(insidenciaResuelto);
		
		return "redirect:/views/insidencia/";
	}
}

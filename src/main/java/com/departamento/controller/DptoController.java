package com.departamento.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.departamento.entity.Departamento;
import com.departamento.entity.Propietario;
import com.departamento.entity.visitante;
import com.departamento.service.DepartamentoService;
import com.departamento.service.PropietarioService;

@Controller
@RequestMapping("/views/departamentos")
public class DptoController {

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private PropietarioService propietarioservice;

	@Secured("ROLE_GERENTE")
	@GetMapping("/")
	public String listarDptos(Model model) {
		List<Departamento> listadoDepartamentos = departamentoService.listarDptos();

		model.addAttribute("titulo", "Lista de departamentos");
		model.addAttribute("departamentos", listadoDepartamentos);
		return "/views/departamentos/listar";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/registrar")
	public String registrar(Model model) {

		Departamento departamento = new Departamento();
		List<Propietario> propietario = propietarioservice.listarPropietarios();

		model.addAttribute("departamento", departamento);
		model.addAttribute("propietarios", propietario);

		return "/views/departamentos/registrar";
	}

	@Secured("ROLE_GERENTE")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Departamento departamento, BindingResult resul, Model model) {
		Departamento dptoyaexiste=departamentoService.buscarnumdepartamento(departamento.getNumdepartamento());
		Departamento id=departamentoService.buscarPorId(departamento.getIddepartamento());
		
		if (id==null && dptoyaexiste!=null ) 
		{
			model.addAttribute("visitante", departamento);
			model.addAttribute("error", "dpto ya existe ,ingrese un numero distinto al registrado en el sistema");
			System.out.println("Ingresar datos correctos");
			return "/views/departamentos/registrar";
		}
		departamento.setEstado("1");
		departamento.setFechareg(new Date());

		departamentoService.guardar(departamento);

		return "redirect:/views/departamentos/";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer idDepartamento, Model model) {

		Departamento departamento = departamentoService.buscarPorId(idDepartamento);
		List<Propietario> propietario = propietarioservice.listarPropietarios();

		model.addAttribute("departamento", departamento);
		model.addAttribute("propietarios", propietario);

		return "/views/departamentos/registrar";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idDepartamento) {

		Departamento depart = departamentoService.buscarPorId(idDepartamento);
		depart.setEstado("0");
		departamentoService.guardar(depart);

		return "redirect:/views/departamentos/";
	}

}

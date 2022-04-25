package com.departamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.departamento.entity.Departamento;
import com.departamento.service.DepartamentoService;




@Controller
@RequestMapping("/views/departamentos")
public class DptoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/")
	public String listarDptos(Model model) {
		List<Departamento> listadoDepartamentos = departamentoService.listarDptos();
		
		model.addAttribute("titulo","Lista de departamentos");
		model.addAttribute("departamentos", listadoDepartamentos);
		return "/views/departamentos/listar";
	}
	
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		Departamento departamento = new Departamento();
		
		model.addAttribute("departamento", departamento);
		
		return "/views/departamentos/registrar";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Departamento departamento) {
		
		departamentoService.guardar(departamento);
		System.out.println("Departamento guardado Exitosamente");
		return "redirect:/views/departamentos/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idDepartamento ,Model model) {
		
		Departamento departamento = departamentoService.buscarPorId(idDepartamento);
		
		model.addAttribute("departamento", departamento);
		
		return "/views/departamentos/registrar";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idDepartamento) {
		
		departamentoService.eliminar(idDepartamento);
		System.out.println("Registro eliminado exitosamente");
		
		return "redirect:/views/departamentos/";
	}

}

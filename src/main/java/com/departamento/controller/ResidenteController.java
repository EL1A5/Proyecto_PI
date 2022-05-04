package com.departamento.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.departamento.entity.Departamento;
import com.departamento.entity.Mascota;
import com.departamento.entity.Propietario;
import com.departamento.entity.Residente;
import com.departamento.service.DepartamentoService;
import com.departamento.service.MascotaService;
import com.departamento.service.ResidenteService;

@Controller
@RequestMapping("/views/Residente/")
public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;

	@Autowired
	private DepartamentoService departamentoService;
	@Autowired
	private MascotaService mascotaservice;

	@Secured("ROLE_GERENTE")
	@GetMapping("/")
	public String listarresidentes(Model model) {
		List<Residente> lstresidentes = residenteService.listarResidentes();

		model.addAttribute("titulo", "Lista de residentes");
		model.addAttribute("residente", lstresidentes);
		return "/views/Residente/listar";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/registrar")
	public String registrar(Model model) {

		Residente residente = new Residente();

		List<Departamento> departamento = departamentoService.listarDptos();
		List<Mascota> mascota = mascotaservice.listarMascota();

		model.addAttribute("residente", residente);
		model.addAttribute("departamentos", departamento);
		model.addAttribute("mascotas", mascota);

		return "/views/Residente/registrar";
	}

	@Secured("ROLE_GERENTE")
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Residente residente, BindingResult resul, Model model) {
		List<Departamento> departamento = departamentoService.listarDptos();
		List<Mascota> mascota = mascotaservice.listarMascota();
		if (resul.hasErrors()) {
			model.addAttribute("residente", residente);
			model.addAttribute("departamentos", departamento);
			model.addAttribute("mascotas", mascota);
			System.out.println("Ingresar datos correctos");
			return "/views/Residente/registrar";
		}

		residente.setFechaReg(new Date());
		residente.setEstado(1);

		residenteService.insertaActualizaResidente(residente);
		System.out.println("Residente guardado Exitosamente");
		return "redirect:/views/Residente/";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Integer idResidente, Model model) {

		Residente residente = residenteService.buscarPorIdResidente(idResidente);
		List<Departamento> departamento = departamentoService.listarDptos();
		List<Mascota> mascota = mascotaservice.listarMascota();

		model.addAttribute("residente", residente);
		model.addAttribute("departamentos", departamento);
		model.addAttribute("mascotas", mascota);
		return "/views/residente/registrar";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idResidente) {

		Residente residente = residenteService.buscarPorIdResidente(idResidente);
		residente.setEstado(0);
		residenteService.insertaActualizaResidente(residente);

		return "redirect:/views/Residente/";
	}

}

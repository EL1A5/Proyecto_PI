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
import com.departamento.entity.Residente;
import com.departamento.service.ResidenteService;

@Controller
@RequestMapping("/views/residentes")
public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;
	
	@GetMapping("/")
	public String listarDptos(Model model) {
		List<Residente> listadoResidentes = residenteService.listarResidentes();
		model.addAttribute("titulo","Lista de Residentes");
		model.addAttribute("residentes", listadoResidentes);
		return "/views/residentes/listar";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		
		Residente residente = new Residente();
		
		model.addAttribute("residente", residente);
		
		return "/views/residentes/registrar";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Residente residente) {
		residenteService.guardar(residente);
		System.out.println("Residente guardado Exitosamente");
		return "redirect:/views/residentes/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idResidente ,Model model) {
		
		Residente residente = residenteService.buscarPorId(idResidente);
		
		model.addAttribute("Residente", residente);
		
		return "/views/residentes/registrar";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idResidente) {
		residenteService.eliminar(idResidente);
		System.out.println("Residente eliminado exitosamente");
		
		return "redirect:/views/residentes/";
	}

}




	
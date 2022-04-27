package com.departamento.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes atribute) {

		if (error != null) {
			model.addAttribute("error", "ERROR DE ACCESO: usuario o password es incorrecto");
		}
		if (error != null) {
			model.addAttribute("error", "ERROR DE ACCESO: usuario o password es incorrecto");
		}
		if (principal != null) {
			atribute.addFlashAttribute("warning", "Ya inicio sesion previamente");
			return "redirect:/";
		}
		
		if (logout != null) {
			model.addAttribute("success", "Cerro Sesion con Exito");
		}
		
		return "login";
	}
}

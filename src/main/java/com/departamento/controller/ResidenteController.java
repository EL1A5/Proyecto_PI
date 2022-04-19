package com.departamento.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.departamento.entity.Residente;
import com.departamento.service.ResidenteService;


@RestController
@RequestMapping("/rest/residentes")
@CrossOrigin(origins = "http://localhost:4200")
public class ResidenteController {
	@Autowired
	private ResidenteService residenteService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Residente>> listaResidente() {
		List<Residente> lista = residenteService.listarResidentes();
		return ResponseEntity.ok(lista);
	}
    @PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registraResidente(@RequestBody Residente obj) {
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			
			obj.setIdResidente(0);
			Residente objSalida = residenteService.insertaActualizaResidente(obj);
			
				if (objSalida == null) {
					salida.put("mensaje", "Error en el registro ");
				} else {
					salida.put("mensaje", "Registro exitoso");   }
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en el registro " + e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}

}

			  
    

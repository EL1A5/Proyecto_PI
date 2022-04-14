package com.departamento.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import com.departamento.entity.Residente;
import com.departamento.service.ResidenteService;
import com.departamento.util.AppSettings;

@RestController
@RequestMapping("/url/Residente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ResidenteController {
	@Autowired
	private ResidenteService Service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Residente>> listMarcas(){
		return ResponseEntity.ok(Service.listaResidente());
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registraResidente(@RequestBody Residente obj) {
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			
			obj.setIdResidente(0);
			obj.setFechaReg(new Date());
			Residente objSalida = Service.registraActualizaResidente(obj);
			
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

	
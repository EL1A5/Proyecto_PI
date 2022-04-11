package com.departamento.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/rest/residente")
public class ResidenteController {
	@Autowired
	private ResidenteService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Residente>> listaResidente() {
		List<Residente> lista = service.listaResidente();
		return ResponseEntity.ok(lista);
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertaResidente(@RequestBody Residente obj) {
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Residente> lstResidente = service.listaResidentePorDni(obj.getDni());
			if (CollectionUtils.isEmpty(lstResidente)) {
				obj.setIdresidente(0);
				Residente objSalida = service.insertaActualizaResidente(obj);
				if (objSalida == null) {
					salida.put("mensaje", "Error en el registro del Residente ");
				}else {
					salida.put("mensaje", "Residente registrado exitosamente");
				}
			}else {
				salida.put("mensaje", "El DNI de Residente ya existe : " + obj.getDni());
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en el registro del Residente " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	}
	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizaResidente(@RequestBody Residente obj) {
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			Optional<Residente> optional =  service.listaResidentePorId(obj.getIdresidente());
			if (optional.isPresent()) {
				List<Residente> lstResidente = service.listaResidentePorDniDiferenteDelMismo(obj.getDni(), obj.getIdresidente());
				if (CollectionUtils.isEmpty(lstResidente)) {
					Residente objSalida = service.insertaActualizaResidente(obj);
					if (objSalida == null) {
						salida.put("mensaje", "Error en actualizar el Residente ");
					}else {
						salida.put("mensaje", "Actualización del Residente exitosa");
					}
				}else {
					salida.put("mensaje", "El DNI Residente ya existe : " + obj.getDni());
				}
			}else {
				salida.put("mensaje", "El ID Residente no existe : " + obj.getIdresidente());
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en la actualización del Residente" + e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}

	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> eliminaResidente(@PathVariable int id) {
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			Optional<Residente> optional =  service.listaResidentePorId(id);
			if (optional.isPresent()) {
				service.eliminaResidentePorId(id);
				salida.put("mensaje", "Eliminación de Residente exitosa");
			}else {
				salida.put("mensaje", "El ID del Residente no existe : " + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en la eliminación del Residente " + e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/dni/{dni}")
	@ResponseBody
	public ResponseEntity<List<Residente>> listaResidentePorDni(@PathVariable String dni) {
		List<Residente> lista = service.listaResidentePorDni(dni);
		return ResponseEntity.ok(lista);
	}
}


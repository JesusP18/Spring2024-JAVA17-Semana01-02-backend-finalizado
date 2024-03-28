package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Modalidad;
import com.empresa.service.ModalidadService;

@RestController
@RequestMapping("/url/modalidad")
public class ModalidadController {
	
	@Autowired
	private ModalidadService modalidadService;

	@GetMapping
	public List<Modalidad> listaModalidad(){
		List<Modalidad> lstSalida = modalidadService.listaModalidad();
		return lstSalida;
	}
	
	@PostMapping
	public ResponseEntity<?> insertaModalidad(@RequestBody Modalidad obj) {
		
		List<String> ltsMensajes = new ArrayList<>();
		
		obj.setEstado(1);
		obj.setFechaRegistro(new Date());
		obj.setFechaActualizacion(new Date());
		
		Modalidad objSalida = modalidadService.insertaModalidad(obj);
		
		if(objSalida == null) {
			ltsMensajes.add("Error en el registro");
		} else {
			ltsMensajes.add("Se registró la modalidad de id : " + obj.getIdModalidad());
		}
		
		return ResponseEntity.ok(ltsMensajes);
	}
	
}

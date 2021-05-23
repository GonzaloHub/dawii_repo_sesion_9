package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService service;

	@GetMapping
	public ResponseEntity<List<Alumno>> listaAlumnos() {

		List<Alumno> lstAlumno = service.listaAlumno();
		log.info(">>>>>lista>>>>>>" + lstAlumno);
		return ResponseEntity.ok(lstAlumno);
	}

	@PostMapping
	public ResponseEntity<Alumno> registra(@RequestBody Alumno obj) {
		log.info(">>>>>>alumno id>>>>>" + obj.getIdAlumno());
		Alumno alumno = service.insertaActualizaAlumno(obj);
		if (alumno != null) {
			return ResponseEntity.ok(alumno);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
}

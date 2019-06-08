package com.organizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organizacion.model.Organizacion;
import com.organizacion.repository.OrganizacionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/organizaciones")
public class OrganizacionController {

	@Autowired
	private OrganizacionRepository organizacionRepository;
	
	@GetMapping("/")
	public List<Organizacion> getOrganizaciones(){
		log.info("Lista de organizaciones");
		return organizacionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Organizacion getOrganizacionPorId(@PathVariable("id") Long id) {
		log.info("Obtener organizacion por un id");
		return organizacionRepository.getOrganizacionPorId(id);
	}
	
	@PostMapping("/")
	public Organizacion agregarOrganizacion(Organizacion organizacion) {
		log.info("La organizacion agregada es: {}", organizacion);
		return organizacionRepository.add(organizacion);
	}
}

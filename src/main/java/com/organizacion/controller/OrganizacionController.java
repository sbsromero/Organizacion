package com.organizacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organizacion.client.DepartamentoCliente;
import com.organizacion.client.EmpleadoCliente;
import com.organizacion.model.Organizacion;
import com.organizacion.repository.OrganizacionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/organizaciones")
public class OrganizacionController {

	@Autowired
	private OrganizacionRepository organizacionRepository;
	@Autowired
	private DepartamentoCliente departamentoCliente;
	@Autowired
	private EmpleadoCliente empleadoCliente;
	
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

	@GetMapping("/{id}/con-departamentos")
	public Organizacion buscarPorIdConDepartamentos(@PathVariable("id") Long id) {
		log.info("organizacion encontrada: id={}", id);
		Organizacion organizacion = organizacionRepository.getOrganizacionPorId(id);
		organizacion.setDepartamentos(departamentoCliente.buscarPorOrganizacion(organizacion.getId()));
		return organizacion;
	}
	
	@GetMapping("/{id}/con-empleados")
	public Organizacion buscarPorIdConEmpleados(@PathVariable("id") Long id) {
		log.info("organizacion encontrada: id={}", id);
		Organizacion organizacion = organizacionRepository.getOrganizacionPorId(id);
		organizacion.setEmpleados(empleadoCliente.buscarPorOrganizacion(organizacion.getId()));
		return organizacion;
	}

//	
//	@GetMapping("/{id}/with-departments-and-employees")
//	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
//		log.info("Organization find: id={}", id);
//		Organization organization = repository.findById(id);
//		organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
//		return organization;
//	}
//	
	
	
}

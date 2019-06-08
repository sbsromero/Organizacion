package com.organizacion.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.organizacion.model.Departamento;

@FeignClient(value = "servicio-departamento")
public interface DepartamentoCliente {

	@GetMapping("/departamentos/organizacion/{organizacionId}")
	public List<Departamento> buscarPorOrganizacion(@PathVariable("organizacionId") Long organizationId);

	@GetMapping("/departamentos/organizacion/{organizacionId}/con-empleados")
	public List<Departamento> buscarPorOrganizacionConEmpleados(@PathVariable("organizacionId") Long organizationId);
}

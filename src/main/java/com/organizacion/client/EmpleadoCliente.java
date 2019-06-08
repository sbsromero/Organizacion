package com.organizacion.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.organizacion.model.Empleado;

@FeignClient(value = "servicio-empleado")
public interface EmpleadoCliente {

	@GetMapping("/empleados/organizacion/{organizacionId}")
	public List<Empleado> buscarPorOrganizacion(@PathVariable("organizacionId") Long organizacionId);
}

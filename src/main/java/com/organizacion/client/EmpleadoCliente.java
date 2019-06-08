package com.organizacion.client;

import java.util.List;

import com.organizacion.model.Empleado;

public interface EmpleadoCliente {

	public List<Empleado> buscarPorOrganizacion(Long organizacionId);
}

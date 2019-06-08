package com.organizacion.client;

import java.util.List;

import com.organizacion.model.Departamento;

public interface DepartamentoCliente {

	public List<Departamento> buscarPorOrganizacion(Long organizationId);

	public List<Departamento> buscarPorOrganizacionConEmpleados(Long organizationId);
}

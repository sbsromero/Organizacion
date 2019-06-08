package com.organizacion.repository;

import java.util.List;

import com.organizacion.model.Organizacion;

public interface OrganizacionRepository {

	public Organizacion add(Organizacion organizacion);
	public Organizacion getOrganizacionPorId(Long organizacionId);
	public List<Organizacion> findAll();
}

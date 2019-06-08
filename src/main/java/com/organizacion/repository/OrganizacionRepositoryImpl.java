package com.organizacion.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.organizacion.model.Organizacion;

public class OrganizacionRepositoryImpl implements OrganizacionRepository {

	private List<Organizacion> organizaciones = new ArrayList<>();

	@Override
	public Organizacion add(Organizacion organizacion) {
		organizacion.setId((long) organizaciones.size() + 1);
		organizaciones.add(organizacion);
		return organizacion;
	}

	@Override
	public Organizacion getOrganizacionPorId(Long organizacionId) {
		Optional<Organizacion> organizacion = organizaciones.stream().filter(o -> o.getId().equals(organizacionId))
				.findFirst();
		if (organizacion.isPresent())
			return organizacion.get();

		return null;
	}

	@Override
	public List<Organizacion> findAll() {
		return organizaciones;
	}

}

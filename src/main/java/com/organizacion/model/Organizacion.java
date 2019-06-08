package com.organizacion.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Organizacion {

	private Long id;
	private String nombre;
	private String direccion;
	private List<Departamento> departamentos = new ArrayList<>();
	private List<Empleado> empleados = new ArrayList<>();

	public Organizacion(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}
}

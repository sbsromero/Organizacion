package com.organizacion.model;

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
public class Departamento {

	private Long id;
	private String nombre;
	private List<Empleado> empleados;

	public Departamento(String nombre) {
		this.nombre = nombre;
	}
}

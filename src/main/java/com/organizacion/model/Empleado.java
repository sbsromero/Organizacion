package com.organizacion.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Empleado {

	private Long id;
	private String nombre;
	private int edad;
	private String cargo;

	public Empleado(String nombre, int edad, String cargo) {
		this.nombre = nombre;
		this.edad = edad;
		this.cargo = cargo;
	}
}

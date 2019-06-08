package com.organizacion.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.organizacion.model.Empleado;

@Service
public class EmpleadoClienteImpl implements EmpleadoCliente {

	private RestTemplate restTemplate;
	private String empleadosHost;

	@Autowired
	public EmpleadoClienteImpl(RestTemplate restTemplate, @Value("${empleadosHost}") String empleadosHost) {
		this.restTemplate = restTemplate;
		this.empleadosHost = empleadosHost;
	}

	@Override
	public List<Empleado> buscarPorOrganizacion(Long organizacionId) {
		ResponseEntity<List<Empleado>> responseEntity = restTemplate.exchange(
				empleadosHost + "/organizacion/" + organizacionId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Empleado>>() {
				});
		return responseEntity.getBody();
	}

}

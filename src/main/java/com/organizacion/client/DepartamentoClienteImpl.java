package com.organizacion.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.organizacion.model.Departamento;

@Service
public class DepartamentoClienteImpl implements DepartamentoCliente {

	private RestTemplate restTemplate;
	private String departamentoHost;

	@Autowired
	public DepartamentoClienteImpl(RestTemplate restTemplate, @Value("${departamentoHost}") String departamentoHost) {
		this.restTemplate = restTemplate;
		this.departamentoHost = departamentoHost;
	}

	@Override
	public List<Departamento> buscarPorOrganizacion(Long organizationId) {
		ResponseEntity<List<Departamento>> responseEntity = restTemplate.exchange(
				departamentoHost + "/organizacion/" + organizationId, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Departamento>>() {
				});
		return responseEntity.getBody();
	}

	@Override
	public List<Departamento> buscarPorOrganizacionConEmpleados(Long organizationId) {
		return null;
	}

}

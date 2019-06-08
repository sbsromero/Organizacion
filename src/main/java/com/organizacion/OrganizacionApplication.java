package com.organizacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.organizacion.model.Organizacion;
import com.organizacion.repository.OrganizacionRepository;
import com.organizacion.repository.OrganizacionRepositoryImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrganizacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizacionApplication.class, args);
	}
	
	@Bean
	OrganizacionRepository organizacionRepository() {
		OrganizacionRepository organizacionRepository = new OrganizacionRepositoryImpl();
		organizacionRepository.add(new Organizacion("Microsoft", "Redmond, Washington, USA"));
		organizacionRepository.add(new Organizacion("Oracle", "Redwood City, California, USA"));
		return organizacionRepository;
	}

}

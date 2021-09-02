package com.dvs.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dvs.bookstore.service.BDService;

@Configuration
@Profile("teste")
public class TesteConfig {
	@Autowired
	private BDService bdService;
	
	@Bean
	public void instanciaBaseDados() {
		this.bdService.instanciaBaseDados();
	}
}

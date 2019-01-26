package com.elektra.quartz.webs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.elektra.quartz.services.entity.*;
import com.elektra.quartz.services.repository.RepositoryAgenda;
import com.elektra.quartz.services.service.ServiceAgenda;
import com.elektra.quartz.services.serviceImpl.ServiceAgendaImpl;






@SpringBootApplication
public class WebAplicacion {
	public static void main(String[] args) {
		//Agenda a = new Agenda();
		SpringApplication.run(WebAplicacion.class, args);
		
		ServiceAgendaImpl ser = new ServiceAgendaImpl();
		//ser.detAgenda();
	}
}


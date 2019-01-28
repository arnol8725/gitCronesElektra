package com.elektra.quartz.webs.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.elektra.quartz.services.entity.Agenda;
import com.elektra.quartz.services.repository.RepositoryAgenda;

@Configuration
@ComponentScan(basePackages = {
        "com.elektra.quartz.services.entity",
        "com.elektra.quartz.services.repository",
        "com.elektra.quartz.services.service",
        "com.elektra.quartz.services.serviceImpl",
        "com.elektra.quartz.services.dao"
    }
    )
@EntityScan(basePackageClasses = {Agenda.class})
@EnableJpaRepositories(basePackageClasses = {RepositoryAgenda.class})
@PropertySource("file:E:/Users/aperaltap/Documents/workspace-spring-tool-suite-4-4.1.0.RELEASE/crones-master/webs/src/main/resources/application.properties")
public class ConfigWeb {

}

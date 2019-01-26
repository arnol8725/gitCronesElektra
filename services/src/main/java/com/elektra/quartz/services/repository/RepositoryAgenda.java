package com.elektra.quartz.services.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.elektra.quartz.services.entity.Agenda;

@Repository("repositoryAgenda")
public interface RepositoryAgenda extends CrudRepository<Agenda, Long> {

}

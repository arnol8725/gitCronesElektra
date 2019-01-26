package com.elektra.quartz.services.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.elektra.quartz.services.entity.Agenda;
import com.elektra.quartz.services.repository.RepositoryAgenda;
import com.elektra.quartz.services.service.ServiceAgenda;


@Service
public class ServiceAgendaImpl implements ServiceAgenda  {
	
	private static final Log LOG = LogFactory.getLog(ServiceAgendaImpl.class);
	
	@Autowired
	@Qualifier("repositoryAgenda")
	public RepositoryAgenda repositoryAgenda;

	@Override
	public List<Agenda> detAgenda() {
		// TODO Auto-generated method stub
		List<Agenda> det = new ArrayList<Agenda>();
		try {
			det=  (List<Agenda>) repositoryAgenda.findAll();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			LOG.info("Erro en RepositoryAgenda " + e.getMessage());
		}
		
		return det;
	}

}

package com.elektra.quartz.webs.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.elektra.quartz.services.entity.Agenda;
import com.elektra.quartz.services.service.ServiceAgenda;
import com.elektra.quartz.services.serviceImpl.ServiceAgendaImpl;




@CrossOrigin()
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="/rest",method={RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST} )
public class AgendaController {
	private static final Log LOG = LogFactory.getLog(AgendaController.class);
	
	
	//@Autowired(required=false)
	@Autowired
	public ServiceAgendaImpl serviceAgenda;
	
	
	@CrossOrigin
	@GetMapping("/contactosAgenda")	
	public ResponseEntity<List<Agenda>> checkRest(){
		List<Agenda> lista = new ArrayList<Agenda>();
		try {
			LOG.info("metodos checkRest( arnol)" );
			//agendaServiceImpl.listTodosContacts();
			lista = serviceAgenda.detAgenda();
			
			
		}catch(HibernateException e) {
			LOG.info("e="+ e.getStackTrace() );
		}
		return new ResponseEntity<List<Agenda>>(lista,HttpStatus.OK);
		 
	}
	
/*	

	
	@CrossOrigin
	@GetMapping("/contactosAgenda")	
	public ResponseEntity<Respuesta> checkRest(){
		Respuesta resp = new Respuesta();
		//agendaServiceImpl.listTodosContacts();
		//List<Agenda> lista = agendaServiceImpl.listAllContacts();
		resp = agendaServiceImpl.listTodosContacts();
		return new ResponseEntity<Respuesta>(resp,HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/addAgenda", method = {RequestMethod.POST,RequestMethod.OPTIONS})
	    public ResponseEntity<List<Agenda>> createContacto(@RequestBody Agenda agenda,    UriComponentsBuilder ucBuilder) {
	     
		 LOG.info("method addContact" + " -- params "+ agenda.toString());
		 try {
			 agendaServiceImpl.saveContacts(agenda);
		 }catch(Exception e) {
			 
			 String mensaje = "Error al insertar";
			 LOG.info("method addContact" + " error "+ e.getMessage());
		 }
		 	
	      	 
	        List<Agenda> lista = agendaServiceImpl.listAllContacts();
			//return new ResponseEntity<List<Agenda>>(lista,HttpStatus.OK);
	        return null;
	    }
	    
	    */

}

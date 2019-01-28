package com.elektra.quartz.services.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.validator.internal.util.privilegedactions.GetResolvedMemberMethods;
import org.springframework.stereotype.Component;
import com.elektra.quartz.services.entity.Agenda;

@Component
public class Consultas {
	private static final Log LOG = LogFactory.getLog(Consultas.class);

	@PersistenceContext
	private EntityManager entityManager;

	
	
	/*
	 * public Consultas(EntityManager entityManager) { super(); this.entityManager =
	 * entityManager; }
	 */

	public Consultas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Agenda> listTodosContacts() {
		List<Agenda> det = new ArrayList<Agenda>();
		// TODO Auto-generated method stub
		try {

			LOG.info("El valor del stored");
			// det = agendaRepository.detAgendaProcedures(new Long(1));

			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("ARNOL.PAAGENDA.GETAGENDA")
					.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, Agenda.class, ParameterMode.REF_CURSOR).setParameter(1, 1L);

			query.execute();

			List<Object[]> postComments = query.getResultList();
			
			LOG.info("El valor del stored " + det.size());
			//LOG.info("El valor postComments" + det.get(1).nombre );
			for (Object[] agenda : postComments) {
				Agenda a = new Agenda();
				a.id= Integer.parseInt(agenda[0].toString());
				a.nombre =  agenda[1].toString();
				a.apellidoPat=  agenda[2].toString();
				a.apellidoMat =  agenda[3].toString();				
				a.telefono=  agenda[4].toString();
				a.celular=  agenda[5].toString();
				a.email=  agenda[6].toString();
				det.add(a);
				
			}
			
			LOG.info("El valor det" + det.size());

		} catch (HibernateException e) {
			// TODO: handle exception
			LOG.info("error =" + e.getMessage().toString());
		}

		return det;
	}

	public List<Agenda> listTodosContactsFuncion() {
		List<Agenda> det = new ArrayList<Agenda>();
		// TODO Auto-generated method stub
		try {

			LOG.info("El valor del stored");
			// det = agendaRepository.detAgendaProcedures(new Long(1));

			det = entityManager.createNamedQuery("fn_post_and_comments", Agenda.class).setParameter(1, 0)
					.getResultList();

			/*
			 * List<Object[]> dets= (List<Object[]>) entityManager .createNativeQuery(
			 * "SELECT ARNOL.PAAGENDA.FN_GETAGENDA(:postId) FROM DUAL" )
			 * .setParameter("postId", 1L) .getResultList();
			 * 
			 * LOG.info("El valor del stored" +dets.size());
			 */

			// query.execute();

		} catch (HibernateException e) {
			// TODO: handle exception
			LOG.info("error =" + e.getMessage().toString());
		}

		return det;
	}

}

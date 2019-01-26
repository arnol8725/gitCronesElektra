package com.elektra.quartz.webs.crones;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.elektra.quartz.services.entity.Agenda;
import com.elektra.quartz.services.serviceImpl.ServiceAgendaImpl;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Service("mytrigger")
public class MyJobTwo extends QuartzJobBean{
	private static final Log LOG = LogFactory.getLog(MyJobTwo.class);
	
	public static final String COUNT = "count";

	@Autowired
	public ServiceAgendaImpl serviceAgenda;	
	private String name;
	
        protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        	//EntityManagerFactory emf = null;
            EntityManager em = null;
            LOG.info("antes" );
            List<Agenda> detAgenda = new ArrayList<Agenda>();
         /*   ApplicationContext appContext;  */
		/*	try {
				LOG.info("appContext" );
				appContext = (ApplicationContext) ctx.getScheduler().getContext().get("applicationContext");
				LOG.info("appContext"+ appContext.toString() );
				EntityManagerFactory emf = (EntityManagerFactory) appContext.getBean("entityManagerFactory", EntityManagerFactory.class);
	            em = emf.createEntityManager();
	            TransactionSynchronizationManager.bindResource(emf, new EntityManagerHolder(em));
	            LOG.info("em " + em.toString());
	            Consultas con = new Consultas(em);
	            LOG.info("paso con " );
	            con.listTodosContacts();
	            LOG.info("paso listTodosContacts " );
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				LOG.info("error" + e.getMessage());
				e.printStackTrace();
			}
            
       */
          
            
            try {
                	LOG.info("antes de serviceAgenda" );
                		detAgenda=serviceAgenda.detAgenda();
            	    LOG.info("el valor de detAgenda"+ detAgenda.size());
            }catch(Exception e) {
            	  LOG.info("marco algun error" +e.getMessage() + "trace" +e.getStackTrace() );
            }
        	
        	
    	   JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
    	   int cnt = dataMap.getInt(COUNT);
	   JobKey jobKey = ctx.getJobDetail().getKey();
	   System.out.println(jobKey+": "+name+": "+ cnt);
	   cnt++;
	  // LOG.info("det " + det().detAgenda.size());
	   dataMap.put(COUNT,cnt );
        }
	public void setName(String name) {
		this.name = name;
	}
	
	
}

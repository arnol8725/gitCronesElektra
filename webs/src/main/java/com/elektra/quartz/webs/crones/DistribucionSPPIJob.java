package com.elektra.quartz.webs.crones;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.stereotype.Component;

import com.elektra.quartz.services.dao.Consultas;
import com.elektra.quartz.services.entity.Agenda;
import com.elektra.quartz.services.service.ServiceAgenda;


@Component
@DisallowConcurrentExecution
public class DistribucionSPPIJob implements Job {
	
	private static final Log LOG = LogFactory.getLog(MyJobTwo.class);

    @Autowired
    private ServiceAgenda negocio;

    @Autowired
    private Consultas negocioDao;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
        try {
        	List<Agenda> det = new ArrayList<Agenda>();
        	LOG.info("Metodo DistribucionSPPIJob execute");
        	//det = negocio.detAgenda();
        	det = (List<Agenda>) negocioDao.listTodosContacts();
        	LOG.info("el valor de DistribucionSPPIJob.det "+ det.size());
        	LOG.info("el valor de DistribucionSPPIJob.det" +  det.toString());
        	for (int i=0; i < det.size(); i++) {
        		Agenda a = (Agenda) det.get(i);
        		LOG.info("id"+ a);
        		
        		/*a.id=(Integer) det.get(i).id;
        		a.nombre=(String) det.get(i).nombre;
        		a.apellidoPat=(String) det.get(i).apellidoPat;
        		a.apellidoMat=(String) det.get(i).apellidoMat;
        		a.celular=(String) det.get(i).celular;
        		a.email=(String) det.get(i).email;
        		a.telefono=(String) det.get(i).telefono;*/
        		LOG.info("Los nombres son: "+a.id+" "  + a.nombre);
			}
        	
        	LOG.info("Metodo DistribucionSPPIJob paso" + det.size());
        } catch (Exception e) {
        	LOG.info("eroro"+" "  + e.getMessage());
            e.printStackTrace();
        }
    }

    @Bean(name = "distSPPIJob")
    public JobDetail sampleJob() {
        return JobBuilder.newJob(DistribucionSPPIJob.class)
                .withIdentity("job-sppi", "jobs-uniformes")
                .usingJobData("ID", "1")
                .storeDurably()
                .build();
    }

    @Bean(name = "triggerDistribucionSPPI")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("distSPPIJob") JobDetail detJob) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(detJob);
        factoryBean.setCronExpression("0 0/1 * 1/1 * ? *");
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        return factoryBean;
    }

}

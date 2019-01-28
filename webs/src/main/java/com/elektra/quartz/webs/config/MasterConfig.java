package com.elektra.quartz.webs.config;

import java.io.IOException;
import java.util.List;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;



@Configuration
public class MasterConfig {
	
	@Autowired(required=false)
	List<Trigger> listOfTrigger;
	
	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory ) throws IOException, SchedulerException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setOverwriteExistingJobs(true);
		factory.setAutoStartup(true);
		factory.setJobFactory(jobFactory);

		if (!AppUtil.isObjectEmpty(listOfTrigger)) {
			factory.setTriggers(listOfTrigger.toArray(new Trigger[listOfTrigger.size()]));
		}
		factory.setGlobalJobListeners(new AgendaJobListener());
		return factory;
	}

		
}

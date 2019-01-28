package com.elektra.quartz.webs.config;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class AgendaJobListener implements JobListener {
	public static final String LISTENER_NAME = "helloJobListener";

	// It returns the job listener name.
	@Override
	public String getName() {
		return LISTENER_NAME;
	}

	// It executes when the job is going to start executing.
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("Job " + jobName + " is going to start executing.");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println("jobExecutionVetoed method is called.");
	}

	// It executes when the job has been executed.
	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		String jobName = context.getJobDetail().getKey().toString();
		System.out.println("Job " + jobName + " is finished.");
	}
}

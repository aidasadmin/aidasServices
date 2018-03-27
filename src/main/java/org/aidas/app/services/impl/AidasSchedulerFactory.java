package org.aidas.app.services.impl;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class AidasSchedulerFactory {

	private static final Logger logger = Logger.getLogger(AidasSchedulerFactory.class);
	
	private static Scheduler scheduler;
	
	public static synchronized Scheduler  getSchedulerInstance(){
		try {
			if(scheduler == null){
				//Getting the scheduler from SchedulerFactory
				SchedulerFactory schedFactory = new StdSchedulerFactory();
				scheduler = schedFactory.getScheduler();
				scheduler.start();
			}
		} catch (Exception e) {
			logger.error("Exception while getting SCHEDULER Instance");
			e.printStackTrace();
		}
		return scheduler;
	}
}

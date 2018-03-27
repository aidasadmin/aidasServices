package org.aidas.app.config;

import java.util.Locale;

import org.aidas.app.constant.AidasConstants;
import org.aidas.app.constant.AppConstants;
import org.aidas.app.job.LicenseValidatorJob;
import org.aidas.app.services.impl.AidasSchedulerFactory;
import org.aidas.app.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * The Class AppConfiguration.
 */
@Configuration
public class AppConfiguration {
	
	private static final Logger logger = Logger.getLogger(AppConfiguration.class);

	@Bean
	public LocaleResolver localeResolver() {
	 final SessionLocaleResolver slr = new SessionLocaleResolver();
	 slr.setDefaultLocale(Locale.ENGLISH); // Set default Locale as US
	 return slr;
	}
	 
	@Bean
	public ResourceBundleMessageSource messageSource() {
	 final ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	 source.setBasenames("i18n/messages");  // name of the resource bundle 
	 source.setUseCodeAsDefaultMessage(true);
	 return source;
	}
	
	@Bean
	public Object createScheduler(){
		try{
			String requiredFlag = CommonUtil.getPropertyValue(AppConstants.REQUIRED_FLAG);
			if(StringUtils.isBlank(requiredFlag)){
				logger.info("required.flag property is not found in aidas.properties file(AIDAS_HOME directory). SO, TERMINATING THE APPLICATION"); 
				CommonUtil.terminateApplication(0);
			}
			
			String decryptedRequiredFlag = CommonUtil.base64Decrypt(requiredFlag);
			if(!AidasConstants.AIDAS.equals(decryptedRequiredFlag)){
				if(!AidasConstants.VENKI.equals(decryptedRequiredFlag)){
					logger.info("Invalid required flag value found in aidas.properties file(AIDAS_HOME directory). SO, TERMINATING THE APPLICATION"); 
					CommonUtil.terminateApplication(0);
				}
				String groupName = "LicenseValidatorJob_GROUP";
				String jobUniqueName = "LicenseValidatorJob";
				Integer scanFrequency = Integer.parseInt("1");
				
				JobDetail jobDetail = JobBuilder.newJob(LicenseValidatorJob.class).withIdentity(jobUniqueName, groupName).build();
				//jobDetail.getJobDataMap().put("Input_Data", dataSourceInput);
				
				//Creating CronTrigger for JobDetail
				Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobUniqueName, groupName)
						.withSchedule(SimpleScheduleBuilder
								.repeatHourlyForever(scanFrequency)).build(); // "0/5 * * * * ?"
				
				/*Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobUniqueName, groupName)
						.withSchedule(SimpleScheduleBuilder
								.repeatSecondlyForever(scanFrequency)).build();*/ // "0/5 * * * * ?"
				//trigger.getTriggerBuilder().startAt(new Date());
				
				//Assinging job and trigger to scheduler
				AidasSchedulerFactory.getSchedulerInstance().scheduleJob(jobDetail, trigger);
			}
		}catch(Exception e){
			logger.error("Exception while creating License Validator Job. SO, TERMINATING THE APPLICATION", e);
			e.printStackTrace();
			CommonUtil.terminateApplication(-1);
		}finally{
			/*if(inputStream != null){
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		}
		return null;
	}
}

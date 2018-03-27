package org.aidas.app.job;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.aidas.app.constant.AidasConstants;
import org.aidas.app.constant.AppConstants;
import org.aidas.app.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * 
 * @author Venkatesh
 * 
 * Using this class we schedule the tasks
 *
 */

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class LicenseValidatorJob extends QuartzJobBean {

	private static final Logger logger = Logger.getLogger(LicenseValidatorJob.class);
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Properties props = null;
		InputStream inputStream = null;
		try{
			//File aidasPropFile = new File("E:\\aidas"+File.separator+AppConstants.CONFIG_FOLDER+File.separator+AppConstants.CONFIG_FILE_NAME);
			File aidasPropFile = new File(System.getenv(AppConstants.AIDAS_HOME) + File.separator + AppConstants.CONFIG_FOLDER + File.separator + AppConstants.CONFIG_FILE_NAME);
			
			if(!aidasPropFile.exists()){
				logger.info("aidas.properties file is not found in AIDAS_HOME directory. SO, TERMINATING THE APPLICATION"); 
				CommonUtil.terminateApplication(0);
			}
			
			props = new Properties();
			inputStream = new FileInputStream(aidasPropFile);
			props.load(inputStream);
			String requiredFlag = props.getProperty(AppConstants.REQUIRED_FLAG);
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
				logger.info("License validation is required. Hence, validating the license of the application at: " + new Date());
	 		  	String encodedExpiryDateInStr = props.getProperty(AppConstants.VERIFY_DATA);
	 		  	if(StringUtils.isBlank(encodedExpiryDateInStr)){
					logger.info("verify.data property is not found in aidas.properties file(AIDAS_HOME directory). SO, TERMINATING THE APPLICATION"); 
					CommonUtil.terminateApplication(0);
				}
	 		  	Date expiryDate = sdf.parse(CommonUtil.base64Decrypt(encodedExpiryDateInStr));
	 		  	Date currentDate = new Date();
	 		  	if(currentDate.compareTo(expiryDate) > 0){
	 		  		logger.info("Current date: " + currentDate);
	 		  		logger.info("Expiry date as per configuration in aidas.properties: " + expiryDate);
	 		  		logger.info("LICENSE EXPIRED. SO, TERMINATING THE APPLICATION");
	 		  		if(!CommonUtil.terminateApplication(0)){
	 		  			if(!CommonUtil.terminateApplication(-1))
	 		  				CommonUtil.terminateApplication(1);
	 		  		}
	 		  	}
	 		  	logger.info("Application is under License. Validated at:  " + new Date());
			}else{
				logger.info("License validation is NOT required due to required flag value. Hence, license validation is not applicable. At: " + new Date());
			}
		}catch(Exception e){
			logger.error("Exception while validating AIDAS License. SO, TERMINATING THE APPLICATION", e);
			e.printStackTrace();
			CommonUtil.terminateApplication(-1);
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			props = null;
		}
	}
	
}



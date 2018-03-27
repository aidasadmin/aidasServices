package org.aidas.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Map.Entry;
import java.util.Properties;

import org.aidas.app.config.MongoConfig;
import org.aidas.app.constant.AppConstants;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoDatabase;

public class CommonUtil {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	
	/** The props. */
	private static Properties props = null;
	
	private static Properties SYSTEM_PROPS = null;
	
	private static Properties dynamicPathProps = null;
	
	/** The resource. */
	static Resource resource = null;
	
	static Resource mappingResource = null;
	
	/** The context. */
	private static AnnotationConfigApplicationContext context = null;
	
	/**
	 * Gets the property value.
	 *
	 * @param key the key
	 * @return the property value
	 * @throws IOException 
	 */
	public static String getPropertyValue(final String key) {
		
		final String devEnviornment = getSystemPropertyValue("DEV_ENVIRONMENT");
		
		if(devEnviornment.equals("Y")){
			if(props==null){
				resource = new ClassPathResource(File.separator+AppConstants.CONFIG_FILE_NAME);
				try {
					props = PropertiesLoaderUtils.loadProperties(resource);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//logger.error("props : "+props);
			return props.getProperty(key);
		}else{
			
			if(dynamicPathProps==null){
				dynamicPathProps = new Properties();
				try {
					final InputStream inputStream = new FileInputStream(System.getenv(AppConstants.AIDAS_HOME)+File.separator+"config"+File.separator+AppConstants.CONFIG_FILE_NAME);
					//final InputStream inputStream = new FileInputStream("E:\\aidas"+File.separator+"config"+File.separator+AppConstants.CONFIG_FILE_NAME);
					dynamicPathProps.load(inputStream);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return dynamicPathProps.getProperty(key);
		}
	}
	
	public static AnnotationConfigApplicationContext getContext() {
		if (context == null) {
			context = new AnnotationConfigApplicationContext(MongoConfig.class);
		}
		return context;
	}
	
	public static void overrideProperty(final Properties newProps){
		for(Entry<Object, Object> entry : newProps.entrySet()) {
			props.put(entry.getKey(), entry.getValue());
        }
	}
	
	public static MongoTemplate getMongoTemplate(){
		final ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		final MongoTemplate mongoTemplate = (MongoTemplate) ctx.getBean(MongoTemplate.class);
		return mongoTemplate;
	}
	
	public static MongoDatabase getMongoDatabase(){
		final ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		final MongoDatabase mongoDatabase = (MongoDatabase) ctx.getBean(MongoDatabase.class);
		return mongoDatabase;
	}
	
	public static String getSystemPropertyValue(final String key) {
		if(SYSTEM_PROPS==null){
			resource = new ClassPathResource("/"+AppConstants.SYSTEM_CONFIG_FILE_NAME);
			try {
				SYSTEM_PROPS = PropertiesLoaderUtils.loadProperties(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return SYSTEM_PROPS.getProperty(key);
	}
	
	public static Object getObject(String className){
		Object object = null;
		try {
			/*Class binaryClass = classType.getClassLoader().loadClass(className);
			object =  binaryClass.newInstance();*/
			Class classObject = Class.forName(className);
			object = classObject.newInstance();
		} catch (Exception e) {
			logger.error("Cannot Instantiate the object for class name: " + className, e);
			e.printStackTrace();
		}
		return object;
	}
	
	public static SimpleDateFormat getDateFormat(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf;
	}
	
	public static String convertObjectToJsonString(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.error("Exception while converting object to json string", e);
		}
		return jsonInString;
	}
	
	public static Object convertJsonStringToJavaObject(String jsonString, Class<?> classType) {
		try {
			return new ObjectMapper().readValue(jsonString, classType);
		} catch (Exception e) {
			//logger.error("Exception while converting json string to object", e);
		}
		return null;
	}
	
	public static Integer convertStringToInteger(String strInput) {
		Integer integer = 0;
		try {
			integer = Integer.parseInt(strInput);
			return integer;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static JSONObject convertJsonStringToJsonObject(String jsonString) {
		JSONObject jsonObject = null;
		try {
			if(StringUtils.isNotBlank(jsonString))
				jsonObject = (JSONObject) new JSONParser().parse(jsonString);
		} catch (Exception e) {
			logger.error("Exception while converting json string to JSON object. JSON String: " + jsonString, e);
		}
		return jsonObject;
	}
	
	public static boolean isIntegerType(Object object){
		try{
			Integer.parseInt(object.toString());
			return true;
		}catch(Exception e){}
		return false;
	}
	
	public static boolean isDoubleType(Object object){
		try{
			Double.parseDouble(object.toString());
			return true;
		}catch(Exception e){}
		return false;
	}
	
	public static String base64Encrypt(String dataToEncrypt) {
		try {
			return new String(Base64.encodeBase64(dataToEncrypt.getBytes("UTF-8")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String base64Decrypt(String encryptedData) {
		try {
			return new String(Base64.decodeBase64(encryptedData));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static boolean terminateApplication(int exitType){
		try{
			System.exit(exitType);
		}catch(Exception e){
			logger.error("Exception while terminating the application for LICENSE. ExitType: " + exitType, e);
		}
		return false;
	}
	
}

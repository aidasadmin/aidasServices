package org.aidas.app.util;

import java.util.Arrays;

import org.aidas.app.config.MongoConfig;
import org.aidas.app.constant.AppConstants;
import org.aidas.app.dto.MongoTenantProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 * The Class ConfigurationUtil.
 */

public class ConfigurationUtil {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationUtil.class);
	
	private static AnnotationConfigApplicationContext context = null;
	
	private static MongoClient mongoClient = null;
	
	private static MongoDatabase mongoDatabase = null;
	
	public static MongoDatabase getMongoDatabaseByTenant(String tenantId){
		//final ConfigurationUtil config = new ConfigurationUtil();
		logger.debug("tenantId : "+tenantId);
		final MongoDatabase mongoDatabase = ConfigurationUtil.getMongoDatabaseByProperties(ConfigurationUtil.getMongoDbProperties(tenantId));
		return mongoDatabase;
	}
	
	/*public MongoTenantProperties getMongoDbProperties(final String tenantId) {
		
		final Query query = new Query(Criteria.where("tenantId").is(tenantId));
		
		final EISDatasourcesModel eisDatasources = getMongoTemplate().findOne(query , EISDatasourcesModel.class);
		logger.debug("eisDatasources : "+eisDatasources);
		final String mongoPassword  = decryptData(eisDatasources.getPassword());
		
		final MongoTenantProperties mongoTenantProperties = new MongoTenantProperties();
		mongoTenantProperties.setHostName(eisDatasources.getHostname());
		mongoTenantProperties.setDatabaseName(eisDatasources.getDbname());
		mongoTenantProperties.setPassword(mongoPassword);
		mongoTenantProperties.setPortNumber(String.valueOf(eisDatasources.getPort()));
		mongoTenantProperties.setSslEnabled(false);
		mongoTenantProperties.setUserName(eisDatasources.getUsername());
		logger.debug("mongoTenantProperties : "+mongoTenantProperties);
		return mongoTenantProperties;
	}*/
	
	public static MongoTenantProperties getMongoDbProperties(final String tenantId) {
		final String mongoHostIp = CommonUtil.getPropertyValue(AppConstants.MONGO_DB_IP);
		final String mongoUserName = CommonUtil.getPropertyValue(AppConstants.MONGO_DB_USERNAME);
		String mongoPassword = CommonUtil.base64Decrypt(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_PASSWORD));
		final Integer mongoDbPort = Integer.valueOf(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_PORT));
		final String mongoDataBaseName = CommonUtil.getPropertyValue(AppConstants.MONGO_DB_NAME);
		
		final MongoTenantProperties mongoTenantProperties = new MongoTenantProperties();
		mongoTenantProperties.setHostName(mongoHostIp);
		mongoTenantProperties.setDatabaseName(mongoDataBaseName);
		mongoTenantProperties.setPassword(mongoPassword);
		mongoTenantProperties.setPortNumber(String.valueOf(mongoDbPort));
		mongoTenantProperties.setSslEnabled(false);
		mongoTenantProperties.setUserName(mongoUserName);
		logger.debug("mongoTenantProperties : "+mongoTenantProperties);
		return mongoTenantProperties;
	}

	public  static MongoDatabase getMongoDatabaseByProperties(MongoTenantProperties mongoTenantProperties) {
		MongoDatabase mongoDatabase = null;
		if(mongoClient==null){
			final MongoCredential credential = MongoCredential.createCredential(mongoTenantProperties.getUserName(), mongoTenantProperties.getDatabaseName(), mongoTenantProperties.getPassword().toCharArray());
			final MongoClientOptions options = MongoClientOptions.builder().sslEnabled(mongoTenantProperties.isSslEnabled()).build();
			mongoClient = new MongoClient(new ServerAddress(mongoTenantProperties.getHostName(), Integer.parseInt(mongoTenantProperties.getPortNumber())), 
					Arrays.asList(credential),options);
		}
		mongoDatabase = mongoClient.getDatabase(mongoTenantProperties.getDatabaseName());
		
		return mongoDatabase;
	}
	
	public synchronized static MongoDatabase getMongoDatabase() {
		if(mongoClient == null){
			MongoTenantProperties mongoTenantProperties = getMongoDbProperties(null);
			final MongoCredential credential = MongoCredential.createCredential(mongoTenantProperties.getUserName(), mongoTenantProperties.getDatabaseName(), mongoTenantProperties.getPassword().toCharArray());
			final MongoClientOptions options = MongoClientOptions.builder().sslEnabled(mongoTenantProperties.isSslEnabled()).build();
			mongoClient = new MongoClient(new ServerAddress(mongoTenantProperties.getHostName(), Integer.parseInt(mongoTenantProperties.getPortNumber())), 
					Arrays.asList(credential),options);
			mongoDatabase = mongoClient.getDatabase(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_NAME));
		}
		return mongoDatabase;
	}
	
	public static MongoTemplate getMongoTemplate() {
		final MongoTemplate mongoTemplate = getContext().getBean(MongoTemplate.class);
		return mongoTemplate;
	}
	
	/*public static String decryptData(String encryptedData){
		String decryptedData= AESEncryption.decryptText(encryptedData);
		return decryptedData;
	}*/
	
	public static AnnotationConfigApplicationContext getContext() {
		if (context == null) {
			context = new AnnotationConfigApplicationContext(MongoConfig.class);
		}
		return context;
	}
}

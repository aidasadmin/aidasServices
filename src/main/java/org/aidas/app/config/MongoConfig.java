package org.aidas.app.config;

import java.util.Arrays;

import org.aidas.app.constant.AppConstants;
import org.aidas.app.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 * The Class MongoConfig.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);
	
	/* (non-Javadoc)
	 * 
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#getDatabaseName()
	 */
	@Override
	protected String getDatabaseName() {
		return CommonUtil.getPropertyValue(AppConstants.MONGO_DB_NAME);
	}

	/* (non-Javadoc)
	 * 
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo()
	 */
	@Override
	public Mongo mongo() throws Exception {
		final int mongoDbPort = Integer.valueOf(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_PORT));
		final MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
		final MongoClient mongoClient = new MongoClient(new ServerAddress(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_IP), mongoDbPort),
				options);
		return mongoClient;
	}
	
	/**
	 * Gets the mongo database.
	 *
	 * @return the mongo database
	 */
	@Bean
	public MongoDatabase getMongoDatabase() {
		final MongoClient mongoClient = getMongoClient();
		return mongoClient.getDatabase(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_NAME));
	}
	
	/**
	 * Gets the mongo client.
	 *
	 * @return the mongo client
	 */
	@Bean
	public MongoClient getMongoClient() {
		final Integer mongoDbPort = Integer.valueOf(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_PORT));
		String mongoPassword = CommonUtil.base64Decrypt(CommonUtil.getPropertyValue(AppConstants.MONGO_DB_PASSWORD));
		final String mongoUserName = CommonUtil.getPropertyValue(AppConstants.MONGO_DB_USERNAME);
		final String mongoHostIp = CommonUtil.getPropertyValue(AppConstants.MONGO_DB_IP);
		final String mongoDataBaseName = CommonUtil.getPropertyValue(AppConstants.MONGO_DB_NAME);
		final MongoCredential credential = MongoCredential.createCredential(mongoUserName, mongoDataBaseName, mongoPassword.toCharArray());
		final MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();
		final MongoClient mongoClient = new MongoClient(new ServerAddress(mongoHostIp, mongoDbPort), Arrays.asList(credential), options);
		return mongoClient;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongoTemplate()
	 */
	@Bean
	public MongoTemplate mongoTemplate() {
		final MongoTemplate mongoTemplate = new MongoTemplate(getMongoClient(),CommonUtil.getPropertyValue(AppConstants.MONGO_DB_NAME));
		return mongoTemplate;
	}
}

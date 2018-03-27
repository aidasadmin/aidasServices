package org.aidas.app;

import org.aidas.app.constant.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class MainApp.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = { AppConstants.BASE_PACKAGES })
@EnableSwagger2
@EnableMongoRepositories(basePackages = AppConstants.BASE_PACKAGES_MONGO_REPOSITORIES)
public class MainApp extends org.springframework.boot.web.support.SpringBootServletInitializer {

	/** The Constant APPLICATION_CLASS. */
	private static final Class<MainApp> APPLICATION_CLASS = MainApp.class;

	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(APPLICATION_CLASS);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(APPLICATION_CLASS, args);
	}

	/* (non-Javadoc)
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(APPLICATION_CLASS);
	}
}
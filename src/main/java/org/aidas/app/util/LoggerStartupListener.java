package org.aidas.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.aidas.app.constant.AppConstants;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

/**
 * The listener interface for receiving loggerStartup events.
 * The class that is interested in processing a loggerStartup
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addLoggerStartupListener<code> method. When
 * the loggerStartup event occurs, that object's appropriate
 * method is invoked.
 *
 * @see LoggerStartupEvent
 */
public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {

	private static final org.slf4j.Logger SYSTEM_LOGGER = org.slf4j.LoggerFactory.getLogger(LoggerStartupListener.class);
	
	/** The Constant LOG_FILE_NAME. */
	private static final String LOG_FILE_NAME = "AppLog";

	/** The resource loader. */
	private ResourceLoader resourceLoader;

	/** The system property. */
	private static Properties SYSTEM_PROPERTY;

	/** The started. */
	private boolean started = false;

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.core.spi.LifeCycle#start()
	 */
	@Override
	public void start() {
		
		SYSTEM_LOGGER.info("==== LoggerStartupListener started =====");
		
		if (started) {
			return;
		}

		if (resourceLoader == null) {
			resourceLoader = new DefaultResourceLoader();
		}

		try {
			SYSTEM_PROPERTY = loadProperties(AppConstants.SYSTEM_CONFIG_FILE_NAME);

		} catch (IOException e) {
			e.printStackTrace();
			SYSTEM_LOGGER.info("==== Error while loading the files====="+e.getMessage());
		}

		final Context context = getContext();
		String logFile = getSystemField("LOG_FILE");

		logFile = (logFile != null && logFile.length() > 0) ? logFile : LOG_FILE_NAME;

		context.putProperty("APP_HOME", System.getProperty("user.dir"));
		context.putProperty("LOG_FILE", logFile);
		started = true;
	}

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.core.spi.LifeCycle#stop()
	 */
	@Override
	public void stop() {
	}

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.core.spi.LifeCycle#isStarted()
	 */
	@Override
	public boolean isStarted() {
		return started;
	}

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.classic.spi.LoggerContextListener#isResetResistant()
	 */
	@Override
	public boolean isResetResistant() {
		return true;
	}

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.classic.spi.LoggerContextListener#onStart(ch.qos.logback.classic.LoggerContext)
	 */
	@Override
	public void onStart(LoggerContext context) {
	}

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.classic.spi.LoggerContextListener#onReset(ch.qos.logback.classic.LoggerContext)
	 */
	@Override
	public void onReset(LoggerContext context) {
	}

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.classic.spi.LoggerContextListener#onStop(ch.qos.logback.classic.LoggerContext)
	 */
	@Override
	public void onStop(LoggerContext context) {
	}

	/* (non-Javadoc)
	 * 
	 * @see ch.qos.logback.classic.spi.LoggerContextListener#onLevelChange(ch.qos.logback.classic.Logger, ch.qos.logback.classic.Level)
	 */
	@Override
	public void onLevelChange(Logger arg0, Level arg1) {
		SYSTEM_LOGGER.info("level changed :========>>>"+ arg0.getName() +""+ arg1.levelStr);
	}

	/**
	 * Gets the field.
	 *
	 * @param key the key
	 * @return the field
	 */
	/*public static String getField(String key) {
		String value = DATAINFO.getProperty(key);
		if (value != null) {
			value = value.trim();
		}
		return value == null ? "" : value;
	}*/

	/**
	 * Gets the system field.
	 *
	 * @param key the key
	 * @return the system field
	 */
	public static String getSystemField(String key) {
		String value = SYSTEM_PROPERTY.getProperty(key);
		if (value != null) {
			value = value.trim();
		}
		return value == null ? "" : value;
	}

	/**
	 * Gets the prop values.
	 *
	 * @param prop the prop
	 * @param propFileName the prop file name
	 * @return the prop values
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Properties getPropValues(Properties prop, String propFileName) throws IOException {

		prop = new Properties();
		final File file = new File(propFileName);
		if (!file.exists())
			return null;

		final InputStream inputStream = new FileInputStream(propFileName);
		prop.load(inputStream);

		return prop;
	}

	/**
	 * Load properties.
	 *
	 * @param fileProps the file props
	 * @return the properties
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Properties loadProperties(String fileProps) throws IOException {
		SYSTEM_LOGGER.info("loading Properties file : "+fileProps);
		final Properties properties = new Properties();
		InputStream inpStream = null;

		try {
			inpStream = this.getClass().getClassLoader().getResourceAsStream(fileProps);
			properties.load(inpStream);
			return properties;
		} catch(IOException ioException){
			ioException.printStackTrace();
			SYSTEM_LOGGER.error("Error while loading the files : "+ioException.getMessage());
		}
		finally {
			inpStream.close();
		}
		return properties;

	}
}

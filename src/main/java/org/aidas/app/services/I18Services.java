package org.aidas.app.services;

import java.util.Locale;

/**
 * The Interface I18Services.
 */
public interface I18Services {

	/**
	 * Gets the message.
	 *
	 * @param messageCode the message code
	 * @param locale the locale
	 * @param placeHoldersArray the place holders array
	 * @return the message
	 */
	String getMessage(String messageCode, Locale locale, Object[] placeHoldersArray);
}

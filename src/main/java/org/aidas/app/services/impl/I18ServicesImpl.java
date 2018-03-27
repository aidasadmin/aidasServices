package org.aidas.app.services.impl;

import java.util.Locale;

import org.aidas.app.services.I18Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * The Class I18ServicesImpl.
 */
@Service
public class I18ServicesImpl implements I18Services {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(I18ServicesImpl.class);

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/* (non-Javadoc)
	 * @see org.ramyam.pm.services.I18Services#getMessage(java.lang.String, java.util.Locale, java.lang.Object[])
	 */
	@Override
	public String getMessage(String messageCode, Locale locale, Object[] placeHoldersArray) {

		return messageSource.getMessage(messageCode, placeHoldersArray, locale);
	}
}

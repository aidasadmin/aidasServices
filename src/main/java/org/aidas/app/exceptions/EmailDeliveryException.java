package org.aidas.app.exceptions;

/**
 * The Class EmailDeliveryException.
 */
public class EmailDeliveryException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1140150859930457857L;

	/**
	 * Instantiates a new email delivery exception.
	 *
	 * @param id the id
	 */
	public EmailDeliveryException(String id) {
		super(String.format("Email delivery failed with id: <%s>", id));
	}

	/**
	 * Instantiates a new email delivery exception.
	 */
	public EmailDeliveryException() {
		super(String.format("Email delivery failed..."));
	}
}

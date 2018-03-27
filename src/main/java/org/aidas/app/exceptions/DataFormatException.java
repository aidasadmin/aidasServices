package org.aidas.app.exceptions;

/**
 * for HTTP 400 errors.
 */
public final class DataFormatException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7306647782307714613L;

	/**
	 * Instantiates a new data format exception.
	 */
	public DataFormatException() {
		super();
	}

	/**
	 * Instantiates a new data format exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public DataFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new data format exception.
	 *
	 * @param message the message
	 */
	public DataFormatException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new data format exception.
	 *
	 * @param cause the cause
	 */
	public DataFormatException(Throwable cause) {
		super(cause);
	}
}
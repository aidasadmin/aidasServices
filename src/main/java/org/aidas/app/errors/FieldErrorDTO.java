package org.aidas.app.errors;

/**
 * The Class FieldErrorDTO.
 */
public final class FieldErrorDTO {

	/** The field. */
	private final String field;

	/** The message. */
	private final String message;

	/**
	 * Instantiates a new field error DTO.
	 *
	 * @param field the field
	 * @param message the message
	 */
	public FieldErrorDTO(String field, String message) {
		this.field = field;
		this.message = message;
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
}

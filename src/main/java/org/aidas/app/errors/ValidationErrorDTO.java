package org.aidas.app.errors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class ValidationErrorDTO.
 */
public final class ValidationErrorDTO {

	/** The field errors. */
	private final List<FieldErrorDTO> fieldErrors = new ArrayList<FieldErrorDTO>();

	/**
	 * Instantiates a new validation error DTO.
	 */
	public ValidationErrorDTO() {

	}

	/**
	 * Adds the field error.
	 *
	 * @param path the path
	 * @param message the message
	 */
	public void addFieldError(String path, String message) {
		final FieldErrorDTO error = new FieldErrorDTO(path, message);
		fieldErrors.add(error);
	}

	/**
	 * Gets the field errors.
	 *
	 * @return the field errors
	 */
	public List<FieldErrorDTO> getFieldErrors() {
		return Collections.unmodifiableList(fieldErrors);
	}
}

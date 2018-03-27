package org.aidas.app.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

/**
 * The Class RestErrorHandler.
 */
@ControllerAdvice
public final class RestErrorHandler {

	/** The message source. */
	private final MessageSource messageSource;

	/**
	 * Instantiates a new rest error handler.
	 *
	 * @param messageSource the message source
	 */
	@Autowired
	public RestErrorHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * Process validation error.
	 *
	 * @param ex the ex
	 * @return the validation error DTO
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
		final BindingResult result = ex.getBindingResult();
		final List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}

	/**
	 * Process field errors.
	 *
	 * @param fieldErrors the field errors
	 * @return the validation error DTO
	 */
	private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		final ValidationErrorDTO dto = new ValidationErrorDTO();

		for (FieldError fieldError : fieldErrors) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			dto.addFieldError(fieldError.getField(), localizedErrorMessage);
		}
		return dto;
	}

	/**
	 * Resolve localized error message.
	 *
	 * @param fieldError the field error
	 * @return the string
	 */
	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		final Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

		// If the message was not found, return the most accurate field error
		// code instead.
		// You can remove this check if you prefer to get the default error
		// message.
		if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
			final String[] fieldErrorCodes = fieldError.getCodes();
			localizedErrorMessage = fieldErrorCodes[0];
		}

		return localizedErrorMessage;
	}
}

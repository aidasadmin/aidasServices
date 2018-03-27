package org.aidas.app.constant;

/**
 * The Interface AppMessage.
 */
public interface AppMessage {

	/** The Constant REQUEST_PROCESSED_SUCCESSFULLY. */
	public static final String REQUEST_PROCESSED_SUCCESSFULLY = "request.processed.successfully";

	/** The Constant REQUEST_PROCESSED_FAILED. */
	public static final String REQUEST_PROCESSED_FAILED = "request.processed.failed";

	/** The Constant INTERNAL_SERVER_ERROR. */
	public static final String INTERNAL_SERVER_ERROR = "internal.server.error";
	
	public static final String USERNAME_PASSWORD_EMPTY = "username.password.empty";

	/** The Constant INVALID_USERNAME_PASSWORD. */
	public static final String INVALID_USERNAME_PASSWORD = "invalid.username.password";

	/** The Constant LOGIN_SUCCESSFUL. */
	public static final String LOGIN_SUCCESSFUL = "login.successful";
	
	public static final String INVALID_JSON_INPUT = "invalid.json.input";

	/** The Constant SESSION_KEY_EMPTY. */
	public static final String SESSION_KEY_EMPTY = "session.key.empty";

	/** The Constant INVALID_SESSION_KEY. */
	public static final String INVALID_SESSION_KEY = "invalid.session.key";

	/** The Constant INACTIVE_SESSION_KEY. */
	public static final String INACTIVE_SESSION_KEY = "inactive.session.key";

	/** The Constant LOGOUT_SUCCESSFUL. */
	public static final String LOGOUT_SUCCESSFUL = "logout.successful";

	/** The Constant FOLDER_ID_EMPTY. */
	public static final String FOLDER_ID_EMPTY = "folder.id.empty";
}

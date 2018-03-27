package org.aidas.app.response.dto;

/**
 * The Class LoginResponseDTO.
 */
public class LoginResponseDTO extends GenericResponse {
	

	/** The session key. */
	private String sessionKey;

	/** The user name. */
	private String user_name;
	
	/**
	 * Instantiates a new login response DTO.
	 */
	public LoginResponseDTO(){ }
	
	/**
	 * Instantiates a new login response DTO.
	 *
	 * @param sessionKey the session key
	 * @param user_name the user name
	 */
	public LoginResponseDTO(String sessionKey, String user_name) {
		this.sessionKey = sessionKey;
		this.user_name = user_name;
	}
	
	/**
	 * Instantiates a new login response DTO.
	 *
	 * @param status the status
	 * @param response the response
	 * @param sessionKey the session key
	 * @param user_name the user name
	 */
	public LoginResponseDTO(String status, String response, String sessionKey, String user_name) {
		super(status, response);
		this.sessionKey = sessionKey;
		this.user_name = user_name;
	}

	/**
	 * Gets the session key.
	 *
	 * @return the session key
	 */
	public String getSessionKey() {
		return sessionKey;
	}

	/**
	 * Sets the session key.
	 *
	 * @param sessionKey the new session key
	 */
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * Sets the user name.
	 *
	 * @param user_name the new user name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/* (non-Javadoc)
	 * @see org.aidas.app.response.dto.GenericResponse#toString()
	 */
	@Override
	public String toString() {
		return "LoginResponseDTO [sessionKey=" + sessionKey + ", user_name=" + user_name + "]";
	}

}

package org.aidas.app.request.dto;

/**
 * The Class SessionKeyDTO.
 */
public class SessionKeyDTO {

	/** The session key. */
	private String sessionKey;
	

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SessionKeyDTO [sessionKey=" + sessionKey + "]";
	}

}

package org.aidas.app.response.dto;

/**
 * The Class GenericResponse.
 */
public class GenericResponse {
	
	public GenericResponse(){}
	
	public GenericResponse(String status, String response) {
		this.status = status;
		this.response = response;
	}

	/** The status. */
	private String status;
	
	/** The response. */
	private String response;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenericResponse [status=" + status + ", response=" + response + "]";
	}

}

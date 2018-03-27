package org.aidas.app.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class UserInputDTO.
 */
public class UserInputDTO {

	/** The user name. */
	@NotEmpty
	private String userName;

	/** The tenant id. */
	@NotEmpty
	private String tenantId;

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the tenant id.
	 *
	 * @return the tenant id
	 */
	public String getTenantId() {
		return tenantId;
	}

	/**
	 * Sets the tenant id.
	 *
	 * @param tenantId the new tenant id
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInputDTO [userName=" + userName + ", tenantId=" + tenantId + "]";
	}
}

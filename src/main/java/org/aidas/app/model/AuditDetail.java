package org.aidas.app.model;

import java.util.Date;

/**
 * The Class AuditDetail.
 */
public class AuditDetail {

	/** The created by. */
	private String createdBy;
	
	/** The last modified by. */
	private String lastModifiedBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The last modified date. */
	private Date lastModifiedDate;
	
	/** The remark. */
	private String remark;

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the last modified by.
	 *
	 * @return the last modified by
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * Sets the last modified by.
	 *
	 * @param lastModifiedBy the new last modified by
	 */
	public void setLastModifiedBy(final String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the last modified date.
	 *
	 * @return the last modified date
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * Sets the last modified date.
	 *
	 * @param lastModifiedDate the new last modified date
	 */
	public void setLastModifiedDate(final Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(final String remark) {
		this.remark = remark;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuditDetail [createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdDate="
				+ createdDate + ", lastModifiedDate=" + lastModifiedDate + ", remark=" + remark + "]";
	}
}

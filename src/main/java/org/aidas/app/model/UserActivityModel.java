/*
 * 
 */
package org.aidas.app.model;

import java.util.Date;
import java.util.List;

import org.aidas.app.constant.CollectionConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class UserActivityModel.
 */
@Document(collection = CollectionConstants.COLLECTION_A_USER_ACTIVITY)
public class UserActivityModel {

	/** The id. */
	@Id
	private String id;

	/** The tenant id. */
	@Field("tenant_id")
	private String tenantId;

	/** The user id. */
	@Field("user_id")
	private String userId;

	/** The session start time. */
	@Field("session_start_time")
	private Date sessionStartTime;

	/** The session end time. */
	@Field("session_end_time")
	private Date sessionEndTime;

	/** The session active. */
	@Field("session_active")
	private boolean sessionActive;

	@Field("activity_details")
	private List<ActivityDetails> activityDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStartTime(Date sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public Date getSessionEndTime() {
		return sessionEndTime;
	}

	public void setSessionEndTime(Date sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}

	public Boolean getSessionActive() {
		return sessionActive;
	}

	public void setSessionActive(Boolean sessionActive) {
		this.sessionActive = sessionActive;
	}

	public List<ActivityDetails> getActivityDetails() {
		return activityDetails;
	}

	public void setActivityDetails(List<ActivityDetails> activityDetails) {
		this.activityDetails = activityDetails;
	}

	@Override
	public String toString() {
		return "UserActivityModel [id=" + id + ", tenantId=" + tenantId + ", userId=" + userId + ", sessionStartTime="
				+ sessionStartTime + ", sessionEndTime=" + sessionEndTime + ", sessionActive=" + sessionActive
				+ ", activityDetails=" + activityDetails + "]";
	}
}

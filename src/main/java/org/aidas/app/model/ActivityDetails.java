/*
 * 
 */
package org.aidas.app.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class ActivityDetails.
 */
public class ActivityDetails {

	/** The activity. */
	@Field("activity")
	private String activity;

	/** The activity start time. */
	@Field("activity_start_time")
	private Date activityStartTime;

	/** The activity end time. */
	@Field("activity_end_time")
	private Date activityEndTime;

	/**
	 * Gets the activity.
	 *
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * Sets the activity.
	 *
	 * @param activity the new activity
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * Gets the activity start time.
	 *
	 * @return the activity start time
	 */
	public Date getActivityStartTime() {
		return activityStartTime;
	}

	/**
	 * Sets the activity start time.
	 *
	 * @param activityStartTime the new activity start time
	 */
	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	/**
	 * Gets the activity end time.
	 *
	 * @return the activity end time
	 */
	public Date getActivityEndTime() {
		return activityEndTime;
	}

	/**
	 * Sets the activity end time.
	 *
	 * @param activityEndTime the new activity end time
	 */
	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActivityDetails [activity=" + activity + ", activityStartTime=" + activityStartTime
				+ ", activityEndTime=" + activityEndTime + "]";
	}

}

/*
 * 
 */
package org.aidas.app.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class FolderContent.
 */
public class FolderContent {

	/** The content id. */
	@Field("content_id")
	private String content_id;

	/** The content name. */
	@Field("content_name")
	private String content_name;

	/** The content type. */
	@Field("content_type")
	private String content_type;

	/**
	 * Gets the content id.
	 *
	 * @return the content id
	 */
	public String getContent_id() {
		return content_id;
	}

	/**
	 * Sets the content id.
	 *
	 * @param content_id the new content id
	 */
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}

	/**
	 * Gets the content name.
	 *
	 * @return the content name
	 */
	public String getContent_name() {
		return content_name;
	}

	/**
	 * Sets the content name.
	 *
	 * @param content_name the new content name
	 */
	public void setContent_name(String content_name) {
		this.content_name = content_name;
	}

	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContent_type() {
		return content_type;
	}

	/**
	 * Sets the content type.
	 *
	 * @param content_type the new content type
	 */
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FolderContent [content_id=" + content_id + ", content_name=" + content_name + ", content_type="
				+ content_type + "]";
	}

}

package org.aidas.app.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class FolderGeneral.
 */
public class FolderGeneral {

	/** The id. */
	@Field("id")
	private String id;

	/** The name. */
	@Field("name")
	private String name;

	/** The description. */
	@Field("description")
	private String description;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FolderGeneral [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}

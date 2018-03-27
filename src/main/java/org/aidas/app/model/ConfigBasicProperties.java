/*
 * 
 */
package org.aidas.app.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class ConfigBasicProperties.
 */
public class ConfigBasicProperties {

	/** The name. */
	@Field("name")
	private String name;

	/** The description. */
	@Field("description")
	private String description;

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
		return "BasicProperties [name=" + name + ", description=" + description + "]";
	}
}

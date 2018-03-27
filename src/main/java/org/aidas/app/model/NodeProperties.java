/*
 * 
 */
package org.aidas.app.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class NodeProperties.
 */
public class NodeProperties {

	/** The id. */
	@Field("id")
	private String id;

	/** The name. */
	@Field("name")
	private String name;

	/** The section. */
	@Field("section")
	private List<NodePropertiesSection> section;

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
	 * Gets the section.
	 *
	 * @return the section
	 */
	public List<NodePropertiesSection> getSection() {
		return section;
	}

	/**
	 * Sets the section.
	 *
	 * @param section the new section
	 */
	public void setSection(List<NodePropertiesSection> section) {
		this.section = section;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NodeProperties [id=" + id + ", name=" + name + ", section=" + section + "]";
	}

}

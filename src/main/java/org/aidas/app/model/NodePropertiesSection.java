/*
 * 
 */
package org.aidas.app.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class NodePropertiesSection.
 */
public class NodePropertiesSection {

	/** The header. */
	@Field("header")
	private String header;

	/** The layout type. */
	@Field("layout_type")
	private String layout_type;

	/** The layout components. */
	@Field("layout_components")
	private List<NodePropertiesLayoutComponents> layout_components;

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the new header
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * Gets the layout type.
	 *
	 * @return the layout type
	 */
	public String getLayout_type() {
		return layout_type;
	}

	/**
	 * Sets the layout type.
	 *
	 * @param layout_type the new layout type
	 */
	public void setLayout_type(String layout_type) {
		this.layout_type = layout_type;
	}

	/**
	 * Gets the layout components.
	 *
	 * @return the layout components
	 */
	public List<NodePropertiesLayoutComponents> getLayout_components() {
		return layout_components;
	}

	/**
	 * Sets the layout components.
	 *
	 * @param layout_components the new layout components
	 */
	public void setLayout_components(List<NodePropertiesLayoutComponents> layout_components) {
		this.layout_components = layout_components;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NodePropertiesSection [header=" + header + ", layout_type=" + layout_type + ", layout_components="
				+ layout_components + "]";
	}
}

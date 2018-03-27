/*
 * 
 */
package org.aidas.app.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class NodePropertiesLayoutComponents.
 */
public class NodePropertiesLayoutComponents {

	/** The id. */
	@Field("id")
	private String id;

	/** The layout type. */
	@Field("layout_type")
	private String layout_type;

	/** The display name. */
	@Field("display_name")
	private String display_name;

	/** The tooltip. */
	@Field("tooltip")
	private String tooltip;

	/** The size. */
	@Field("size")
	private String size;

	/** The mandatory. */
	@Field("mandatory")
	private boolean mandatory;

	/** The values. */
	@Field("values")
	private List<String> values;

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
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplay_name() {
		return display_name;
	}

	/**
	 * Sets the display name.
	 *
	 * @param display_name the new display name
	 */
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	/**
	 * Gets the tooltip.
	 *
	 * @return the tooltip
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * Sets the tooltip.
	 *
	 * @param tooltip the new tooltip
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Checks if is mandatory.
	 *
	 * @return true, if is mandatory
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * Sets the mandatory.
	 *
	 * @param mandatory the new mandatory
	 */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	/**
	 * Gets the values.
	 *
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}

	/**
	 * Sets the values.
	 *
	 * @param values the new values
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NodePropertiesLayoutComponents [id=" + id + ", layout_type=" + layout_type + ", display_name="
				+ display_name + ", tooltip=" + tooltip + ", size=" + size + ", mandatory=" + mandatory + ", values="
				+ values + "]";
	}
}

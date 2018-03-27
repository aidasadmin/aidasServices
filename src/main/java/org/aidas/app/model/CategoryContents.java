/*
 * 
 */
package org.aidas.app.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class CategoryContents.
 */
public class CategoryContents {

	/** The id. */
	@Field("id")
	private String id;

	/** The item name. */
	@Field("item_name")
	private String item_name;
	
	/** The icon name. */
	@Field("icon_name")
	private String icon_name;
	
	/** The tooltip. */
	@Field("tooltip")
	private String tooltip;
	
	/** The category. */
	@Field("category")
	private String category;

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
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * Sets the item name.
	 *
	 * @param item_name the new item name
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * Gets the icon name.
	 *
	 * @return the icon name
	 */
	public String getIcon_name() {
		return icon_name;
	}

	/**
	 * Sets the icon name.
	 *
	 * @param icon_name the new icon name
	 */
	public void setIcon_name(String icon_name) {
		this.icon_name = icon_name;
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
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryContents [id=" + id + ", item_name=" + item_name + ", icon_name=" + icon_name + ", tooltip="
				+ tooltip + ", category=" + category + "]";
	}
}

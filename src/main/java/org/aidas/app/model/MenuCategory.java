/*
 * 
 */
package org.aidas.app.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class MenuCategory.
 */
public class MenuCategory {

	/** The id. */
	@Field("id")
	private String id;

	/** The category name. */
	@Field("category_name")
	private String category_name;

	/** The order. */
	@Field("order")
	private Integer order;

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
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategory_name() {
		return category_name;
	}

	/**
	 * Sets the category name.
	 *
	 * @param category_name the new category name
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 *
	 * @param order the new order
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MenuCategory [id=" + id + ", category_name=" + category_name + ", order=" + order + "]";
	}
}

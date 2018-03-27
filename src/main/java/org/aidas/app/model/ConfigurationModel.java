/*
 * 
 */
package org.aidas.app.model;

import java.util.List;

import org.aidas.app.constant.CollectionConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationModel.
 */
@Document(collection = CollectionConstants.COLLECTION_A_CONFIGURATION)
public class ConfigurationModel {

	/** The id. */
	@Id
	private String id;

	/** The basic properties. */
	@Field("basic_properties")
	private ConfigBasicProperties basic_properties;

	/** The menu category. */
	@Field("menu_category")
	private List<MenuCategory> menu_category;

	/** The category contents. */
	@Field("category_contents")
	private List<CategoryContents> category_contents;

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
	 * Gets the basic properties.
	 *
	 * @return the basic properties
	 */
	public ConfigBasicProperties getBasic_properties() {
		return basic_properties;
	}

	/**
	 * Sets the basic properties.
	 *
	 * @param basic_properties the new basic properties
	 */
	public void setBasic_properties(ConfigBasicProperties basic_properties) {
		this.basic_properties = basic_properties;
	}

	/**
	 * Gets the menu category.
	 *
	 * @return the menu category
	 */
	public List<MenuCategory> getMenu_category() {
		return menu_category;
	}

	/**
	 * Sets the menu category.
	 *
	 * @param menu_category the new menu category
	 */
	public void setMenu_category(List<MenuCategory> menu_category) {
		this.menu_category = menu_category;
	}

	/**
	 * Gets the category contents.
	 *
	 * @return the category contents
	 */
	public List<CategoryContents> getCategory_contents() {
		return category_contents;
	}

	/**
	 * Sets the category contents.
	 *
	 * @param category_contents the new category contents
	 */
	public void setCategory_contents(List<CategoryContents> category_contents) {
		this.category_contents = category_contents;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConfigurationModel [id=" + id + ", basic_properties=" + basic_properties + ", menu_category="
				+ menu_category + ", category_contents=" + category_contents + "]";
	}

}

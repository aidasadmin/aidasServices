package org.aidas.app.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class FolderOrganization.
 */
public class FolderOrganization {

	/** The parent folder id. */
	@Field("parent_folder_id")
	private String parent_folder_id;

	/**
	 * Gets the parent folder id.
	 *
	 * @return the parent folder id
	 */
	public String getParent_folder_id() {
		return parent_folder_id;
	}

	/**
	 * Sets the parent folder id.
	 *
	 * @param parent_folder_id the new parent folder id
	 */
	public void setParent_folder_id(String parent_folder_id) {
		this.parent_folder_id = parent_folder_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FolderOrganization [parent_folder_id=" + parent_folder_id + "]";
	}

}

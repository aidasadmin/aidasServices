/*
 * 
 */
package org.aidas.app.model;

import java.util.List;

import org.aidas.app.constant.CollectionConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class FolderModel.
 */
@Document(collection = CollectionConstants.COLLECTION_A_FOLDER)
public class FolderModel {

	/** The id. */
	@Id
	private String id;

	/** The organization. */
	@Field("organization")
	private FolderOrganization organization;

	/** The general. */
	@Field("general")
	private FolderGeneral general;

	/** The content. */
	@Field("content")
	private List<FolderContent> content;

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
	 * Gets the organization.
	 *
	 * @return the organization
	 */
	public FolderOrganization getOrganization() {
		return organization;
	}

	/**
	 * Sets the organization.
	 *
	 * @param organization the new organization
	 */
	public void setOrganization(FolderOrganization organization) {
		this.organization = organization;
	}

	/**
	 * Gets the general.
	 *
	 * @return the general
	 */
	public FolderGeneral getGeneral() {
		return general;
	}

	/**
	 * Sets the general.
	 *
	 * @param general the new general
	 */
	public void setGeneral(FolderGeneral general) {
		this.general = general;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public List<FolderContent> getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(List<FolderContent> content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FolderModel [id=" + id + ", organization=" + organization + ", general=" + general + ", content="
				+ content + "]";
	}
}

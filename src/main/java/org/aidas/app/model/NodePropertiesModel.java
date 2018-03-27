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
 * The Class NodePropertiesModel.
 */
@Document(collection = CollectionConstants.COLLECTION_A_NODE_PROPERTIES)
public class NodePropertiesModel {

	/** The id. */
	@Id
	private String id;

	/** The basic properties. */
	@Field("basic_properties")
	private NodeBasicProperties basic_properties;

	/** The node properties. */
	@Field("node_properties")
	private List<NodeProperties> node_properties;

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
	public NodeBasicProperties getBasic_properties() {
		return basic_properties;
	}

	/**
	 * Sets the basic properties.
	 *
	 * @param basic_properties the new basic properties
	 */
	public void setBasic_properties(NodeBasicProperties basic_properties) {
		this.basic_properties = basic_properties;
	}

	/**
	 * Gets the node properties.
	 *
	 * @return the node properties
	 */
	public List<NodeProperties> getNode_properties() {
		return node_properties;
	}

	/**
	 * Sets the node properties.
	 *
	 * @param node_properties the new node properties
	 */
	public void setNode_properties(List<NodeProperties> node_properties) {
		this.node_properties = node_properties;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NodePropertiesModel [id=" + id + ", basic_properties=" + basic_properties + ", node_properties="
				+ node_properties + "]";
	}

}

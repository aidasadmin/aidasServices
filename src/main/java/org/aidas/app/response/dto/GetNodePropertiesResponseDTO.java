package org.aidas.app.response.dto;

import java.util.List;

import org.aidas.app.model.NodePropertiesModel;

/**
 * The Class GetNodePropertiesResponseDTO.
 */
public class GetNodePropertiesResponseDTO extends GenericResponse {

	/** The data. */
	private List<NodePropertiesModel> data;

	/**
	 * Instantiates a new gets the node properties response DTO.
	 */
	public GetNodePropertiesResponseDTO() {
	};

	/**
	 * Instantiates a new gets the node properties response DTO.
	 *
	 * @param status the status
	 * @param response the response
	 * @param data the data
	 */
	public GetNodePropertiesResponseDTO(String status, String response, List<NodePropertiesModel> data) {
		super(status, response);
		this.data = data;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<NodePropertiesModel> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<NodePropertiesModel> data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see org.aidas.app.response.dto.GenericResponse#toString()
	 */
	@Override
	public String toString() {
		return "GetNodePropertiesResponseDTO [data=" + data + "]";
	}

}

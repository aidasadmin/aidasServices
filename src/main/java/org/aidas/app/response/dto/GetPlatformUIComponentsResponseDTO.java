package org.aidas.app.response.dto;

import java.util.List;

import org.aidas.app.model.ConfigurationModel;

/**
 * The Class GetPlatformUIComponentsResponseDTO.
 */
public class GetPlatformUIComponentsResponseDTO extends GenericResponse {

	/** The data. */
	private List<ConfigurationModel> data;

	/**
	 * Instantiates a new gets the platform UI components response DTO.
	 */
	public GetPlatformUIComponentsResponseDTO() {
	};

	/**
	 * Instantiates a new gets the platform UI components response DTO.
	 *
	 * @param status the status
	 * @param response the response
	 * @param data the data
	 */
	public GetPlatformUIComponentsResponseDTO(String status, String response, List<ConfigurationModel> data) {
		super(status, response);
		this.data = data;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<ConfigurationModel> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(List<ConfigurationModel> data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.aidas.app.response.dto.GenericResponse#toString()
	 */
	@Override
	public String toString() {
		return "GetPlatformUIComponentsResponseDTO [data=" + data + "]";
	}

}

package org.aidas.app.response.dto;

import java.util.List;

import org.aidas.app.model.FolderModel;

/**
 * The Class GetFolderTreeResponseDTO.
 */
public class GetFolderTreeResponseDTO extends GenericResponse {

	/** The data. */
	private List<FolderModel> data;

	/**
	 * Instantiates a new gets the folder tree response DTO.
	 */
	public GetFolderTreeResponseDTO() {
	};

	/**
	 * Instantiates a new gets the folder tree response DTO.
	 *
	 * @param status the status
	 * @param response the response
	 * @param data the data
	 */
	public GetFolderTreeResponseDTO(String status, String response, List<FolderModel> data) {
		super(status, response);
		this.data = data;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public List<FolderModel> getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(List<FolderModel> data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see org.aidas.app.response.dto.GenericResponse#toString()
	 */
	@Override
	public String toString() {
		return "GetFolderTreeResponseDTO [data=" + data + "]";
	}
}

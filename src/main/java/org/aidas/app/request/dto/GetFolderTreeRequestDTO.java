package org.aidas.app.request.dto;

/**
 * The Class GetFolderTreeRequestDTO.
 */
public class GetFolderTreeRequestDTO extends SessionKeyDTO {

	/** The folder id. */
	private String folderId;

	/**
	 * Gets the folder id.
	 *
	 * @return the folder id
	 */
	public String getFolderId() {
		return folderId;
	}

	/**
	 * Sets the folder id.
	 *
	 * @param folderId the new folder id
	 */
	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	/* (non-Javadoc)
	 * @see org.aidas.app.request.dto.SessionKeyDTO#toString()
	 */
	@Override
	public String toString() {
		return "GetFolderTreeRequestDTO [folderId=" + folderId + "]";
	}

}

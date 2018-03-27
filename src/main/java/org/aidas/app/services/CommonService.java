package org.aidas.app.services;

import java.util.Locale;

import org.aidas.app.response.dto.GetFolderTreeResponseDTO;
import org.aidas.app.response.dto.GetNodePropertiesResponseDTO;
import org.aidas.app.response.dto.GetPlatformUIComponentsResponseDTO;

public interface CommonService {

	GetPlatformUIComponentsResponseDTO getPlatformUIComponents(String sessionKey, Locale locale);

	GetNodePropertiesResponseDTO getNodeProperties(String sessionKey, Locale locale);

	GetFolderTreeResponseDTO getFolderTree(String sessionKey, String folderId, Locale locale);

}
package org.aidas.app.controller;

import java.util.Locale;

import org.aidas.app.constant.PathConstant;
import org.aidas.app.response.dto.GetFolderTreeResponseDTO;
import org.aidas.app.response.dto.GetNodePropertiesResponseDTO;
import org.aidas.app.response.dto.GetPlatformUIComponentsResponseDTO;
import org.aidas.app.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = PathConstant.COMMON)
public class CommonServiceController {
	
	@Autowired
	private CommonService commonService;

	
	@CrossOrigin(methods = RequestMethod.GET)
	@GetMapping(value = PathConstant.COMMON_GET_PLATFORM_UI_COMPONENTS, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Provide valid session key", notes = "This API is to get platform UI components by validating session key")
	public GetPlatformUIComponentsResponseDTO getPlatformUIComponents(@RequestHeader("Accept-Language") Locale locale, String sessionKey){ 
		return commonService.getPlatformUIComponents(sessionKey, locale);
	}
	
	@CrossOrigin(methods = RequestMethod.GET)
	@GetMapping(value = PathConstant.COMMON_GET_NODE_PROPERTIES, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Provide valid session key", notes = "This API is to get all node properties by validating session key")
	public GetNodePropertiesResponseDTO getNodeProperties(@RequestHeader("Accept-Language") Locale locale, String sessionKey){ 
		return commonService.getNodeProperties(sessionKey, locale);
	}
	
	@CrossOrigin(methods = RequestMethod.GET)
	@GetMapping(value = PathConstant.COMMON_GET_FOLDER_TREE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Provide valid session key and folder id", notes = "This API is to get folder tree structure for given folder id by validating session key")
	public GetFolderTreeResponseDTO getFolderTree(@RequestHeader("Accept-Language") Locale locale, String sessionKey, String folderId){ 
		return commonService.getFolderTree(sessionKey, folderId, locale);
	}
}

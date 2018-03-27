package org.aidas.app.services.impl;

import java.util.Locale;

import org.aidas.app.constant.AppConstants;
import org.aidas.app.constant.AppMessage;
import org.aidas.app.model.UserActivityModel;
import org.aidas.app.repository.ConfigurationRepository;
import org.aidas.app.repository.FolderRepository;
import org.aidas.app.repository.NodePropertiesRepository;
import org.aidas.app.repository.UserActivityRepository;
import org.aidas.app.response.dto.GetFolderTreeResponseDTO;
import org.aidas.app.response.dto.GetNodePropertiesResponseDTO;
import org.aidas.app.response.dto.GetPlatformUIComponentsResponseDTO;
import org.aidas.app.services.CommonService;
import org.aidas.app.services.I18Services;
import org.aidas.app.services.MongoServices;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonServiceImpl.class);

	@Autowired
	private MongoServices mongoServices;
	
	@Autowired
	private UserActivityRepository userActivityRespository;
	
	@Autowired
	private ConfigurationRepository configurationRepository;
	
	@Autowired
	private FolderRepository folderRepository;
	
	@Autowired
	private NodePropertiesRepository nodePropertiesRepository;
	
	/** The i 18 services. */
	@Autowired
	private I18Services i18Services;

	/** The mapper. */
	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public GetPlatformUIComponentsResponseDTO getPlatformUIComponents(String sessionKey, Locale locale) {
		try{
			/*SessionKeyDTO sessionKeyDTO = (SessionKeyDTO)CommonUtil.convertJsonStringToJavaObject(jsonInput, SessionKeyDTO.class);
			if(sessionKeyDTO == null)
				return new GetPlatformUIComponentsResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_JSON_INPUT, locale, null), null);*/
			
			if(StringUtils.isBlank(sessionKey))
				return new GetPlatformUIComponentsResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.SESSION_KEY_EMPTY, locale, null), null);
			
			UserActivityModel userActivityModel = userActivityRespository.findById(sessionKey);
			if(userActivityModel == null)
				return new GetPlatformUIComponentsResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_SESSION_KEY, locale, null), null);
			
			if(!userActivityModel.getSessionActive())
				return new GetPlatformUIComponentsResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INACTIVE_SESSION_KEY, locale, null), null);
			
			return new GetPlatformUIComponentsResponseDTO(AppConstants.SUCCESS, i18Services.getMessage(AppMessage.REQUEST_PROCESSED_SUCCESSFULLY, locale, null),
					configurationRepository.findAll());
		}catch(Exception e){
			LOGGER.error("Exception in getPlatformUIComponents service. Exception: " + e.getMessage(), e);
			e.printStackTrace();
			return new GetPlatformUIComponentsResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INTERNAL_SERVER_ERROR, locale, null), null);
		}
	}

	@Override
	public GetNodePropertiesResponseDTO getNodeProperties(String sessionKey, Locale locale) {
		try{
			/*SessionKeyDTO sessionKeyDTO = (SessionKeyDTO)CommonUtil.convertJsonStringToJavaObject(jsonInput, SessionKeyDTO.class);
			if(sessionKeyDTO == null)
				return new GetNodePropertiesResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_JSON_INPUT, locale, null), null);*/
			
			if(StringUtils.isBlank(sessionKey))
				return new GetNodePropertiesResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.SESSION_KEY_EMPTY, locale, null), null);
			
			UserActivityModel userActivityModel = userActivityRespository.findById(sessionKey);
			if(userActivityModel == null)
				return new GetNodePropertiesResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_SESSION_KEY, locale, null), null);
			
			if(!userActivityModel.getSessionActive())
				return new GetNodePropertiesResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INACTIVE_SESSION_KEY, locale, null), null);
			
			return new GetNodePropertiesResponseDTO(AppConstants.SUCCESS, i18Services.getMessage(AppMessage.REQUEST_PROCESSED_SUCCESSFULLY, locale, null),
					nodePropertiesRepository.findAll());
		}catch(Exception e){
			LOGGER.error("Exception in getNodeProperties service. Exception: " + e.getMessage(), e);
			e.printStackTrace();
			return new GetNodePropertiesResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INTERNAL_SERVER_ERROR, locale, null), null);
		}
	}

	@Override
	public GetFolderTreeResponseDTO getFolderTree(String sessionKey, String folderId, Locale locale) {
		try{
			/*GetFolderTreeRequestDTO getFolderTreeRequestDTO = (GetFolderTreeRequestDTO)CommonUtil.convertJsonStringToJavaObject(jsonInput, SessionKeyDTO.class);
			if(getFolderTreeRequestDTO == null)
				return new GetFolderTreeResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_JSON_INPUT, locale, null), null);*/
			
			if(StringUtils.isBlank(sessionKey))
				return new GetFolderTreeResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.SESSION_KEY_EMPTY, locale, null), null);
			
			if(StringUtils.isBlank(folderId))
				return new GetFolderTreeResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.FOLDER_ID_EMPTY, locale, null), null);
			
			UserActivityModel userActivityModel = userActivityRespository.findById(sessionKey);
			if(userActivityModel == null)
				return new GetFolderTreeResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_SESSION_KEY, locale, null), null);
			
			if(!userActivityModel.getSessionActive())
				return new GetFolderTreeResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INACTIVE_SESSION_KEY, locale, null), null);
			
			// Return the folder structure for a specific folder (logical folder structure to store job). 
			// This service is called recursively to fetch child tree objects.
			return new GetFolderTreeResponseDTO(AppConstants.SUCCESS, i18Services.getMessage(AppMessage.REQUEST_PROCESSED_SUCCESSFULLY, locale, null),
					folderRepository.findAll());
		}catch(Exception e){
			LOGGER.error("Exception in getFolderTree service. Exception: " + e.getMessage(), e);
			e.printStackTrace();
			return new GetFolderTreeResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INTERNAL_SERVER_ERROR, locale, null), null);
		}
	}
	
}

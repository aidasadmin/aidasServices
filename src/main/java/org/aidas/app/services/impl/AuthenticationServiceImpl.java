package org.aidas.app.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.aidas.app.constant.AidasConstants;
import org.aidas.app.constant.AppConstants;
import org.aidas.app.constant.AppMessage;
import org.aidas.app.model.ActivityDetails;
import org.aidas.app.model.UserActivityModel;
import org.aidas.app.model.UserModel;
import org.aidas.app.repository.UserActivityRepository;
import org.aidas.app.repository.UserRepository;
import org.aidas.app.request.dto.LoginRequestDTO;
import org.aidas.app.response.dto.GenericResponse;
import org.aidas.app.response.dto.LoginResponseDTO;
import org.aidas.app.services.AuthenticationService;
import org.aidas.app.services.I18Services;
import org.aidas.app.services.MongoServices;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	private MongoServices mongoServices;
	
	@Autowired
	private UserRepository userRespository;
	
	@Autowired
	private UserActivityRepository userActivityRespository;
	
	/** The i 18 services. */
	@Autowired
	private I18Services i18Services;

	/** The mapper. */
	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO, Locale locale) {
		try{
			if(StringUtils.isBlank(loginRequestDTO.getUsername()) || StringUtils.isBlank(loginRequestDTO.getPassword()))
				return new LoginResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.USERNAME_PASSWORD_EMPTY, locale, null), null, null);
				
			UserModel userModel = getUserModel(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
			if(userModel == null)
				return new LoginResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_USERNAME_PASSWORD, locale, null), null, null);
			
			//User exists. Hence, creating a new entry in a_user_activity collection
			UserActivityModel userActivityModel = createUserActivity(loginRequestDTO.getUsername(), AidasConstants.ACTIVITY_LOGIN);
			return new LoginResponseDTO(AppConstants.SUCCESS, i18Services.getMessage(AppMessage.LOGIN_SUCCESSFUL, locale, null), 
					userActivityModel.getId(), userModel.getName());
		}catch(Exception e){
			LOGGER.error("Exception in LOGIN service. Exception: " + e.getMessage(), e);
			e.printStackTrace();
			return new LoginResponseDTO(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INTERNAL_SERVER_ERROR, locale, null), null, null);
		}
	}
	
	@Override
	public GenericResponse logout(String sessionKey, Locale locale) {
		try{
			/*SessionKeyDTO sessionKeyDTO = (SessionKeyDTO)CommonUtil.convertJsonStringToJavaObject(jsonInput, SessionKeyDTO.class);
			if(sessionKeyDTO == null)
				return new GenericResponse(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_JSON_INPUT, locale, null));*/
			
			if(StringUtils.isBlank(sessionKey))
				return new GenericResponse(AppConstants.FAILURE, i18Services.getMessage(AppMessage.SESSION_KEY_EMPTY, locale, null));
			
			UserActivityModel userActivityModel = userActivityRespository.findById(sessionKey);
			if(userActivityModel == null)
				return new GenericResponse(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INVALID_SESSION_KEY, locale, null));
			
			if(!userActivityModel.getSessionActive())
				return new GenericResponse(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INACTIVE_SESSION_KEY, locale, null));
			
			updateUserActivity(userActivityModel, false, AidasConstants.ACTIVITY_LOGOUT);
			return new GenericResponse(AppConstants.SUCCESS, i18Services.getMessage(AppMessage.LOGOUT_SUCCESSFUL, locale, null));
		}catch(Exception e){
			LOGGER.error("Exception in LOGOUT service. Exception: " + e.getMessage(), e);
			e.printStackTrace();
			return new GenericResponse(AppConstants.FAILURE, i18Services.getMessage(AppMessage.INTERNAL_SERVER_ERROR, locale, null));
		}
	}
	
	private UserModel getUserModel(String userId, String password){
		//Do password encoding and decoding logic if required 
		return userRespository.findByEmailIdAndPassword(userId, password);
	}
	
	
	private UserActivityModel createUserActivity(String userId, String activityType){
		UserActivityModel userActivityModel = new UserActivityModel();
		userActivityModel.setUserId(userId);
		userActivityModel.setSessionActive(true);
		Date activityStartTime = new Date();
		userActivityModel.setSessionStartTime(activityStartTime);
		
		addOrUpdateActivityDetailsList(userActivityModel, activityType, activityStartTime, activityStartTime);
		return userActivityRespository.save(userActivityModel);
	}
	
	private UserActivityModel updateUserActivity(UserActivityModel userActivityModel, Boolean sessionActiveFlag, String activityType){
		if(!sessionActiveFlag){
			userActivityModel.setSessionActive(sessionActiveFlag);
			userActivityModel.setSessionEndTime(new Date());
		}
		Date activityTime = new Date();
		addOrUpdateActivityDetailsList(userActivityModel, activityType, activityTime, activityTime);
		return userActivityRespository.save(userActivityModel);
	}
	
	private void addOrUpdateActivityDetailsList(UserActivityModel userActivityModel, String activityType, 
			Date activityStartTime, Date activityEndTime){
		
		List<ActivityDetails> activityDetailsList = userActivityModel.getActivityDetails();
		if(activityDetailsList == null)
			activityDetailsList = new ArrayList<>();
		
		ActivityDetails activityDetails = new ActivityDetails();
		activityDetails.setActivity(activityType);
		activityDetails.setActivityStartTime(activityStartTime);
		activityDetails.setActivityEndTime(activityEndTime);
		
		activityDetailsList.add(activityDetails);
		userActivityModel.setActivityDetails(activityDetailsList);
	}
}

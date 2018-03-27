package org.aidas.app.controller;

import java.util.Locale;

import org.aidas.app.constant.PathConstant;
import org.aidas.app.request.dto.LoginRequestDTO;
import org.aidas.app.response.dto.GenericResponse;
import org.aidas.app.response.dto.LoginResponseDTO;
import org.aidas.app.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = PathConstant.AUTHENTICATE)
public class AuthenticationController {
	
	/** The Constant LOGGER. */
	//private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationService authenticationService;

	
	@CrossOrigin(methods = RequestMethod.POST)
	@RequestMapping(value = PathConstant.AUTHENTICATE_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Provide valid username and password", notes = "This API is to do login operation by validating user details")
	public LoginResponseDTO login(@RequestHeader("Accept-Language") Locale locale, @RequestBody LoginRequestDTO loginRequestDTO){ 
		return authenticationService.login(loginRequestDTO, locale);
	}
	
	@CrossOrigin(methods = RequestMethod.GET)
	@GetMapping(value = PathConstant.AUTHENTICATE_LOGOUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Provide valid session key", notes = "This API is to do logout operation by using session key")
	public GenericResponse logout(@RequestHeader("Accept-Language") Locale locale, String sessionKey){ 
		return authenticationService.logout(sessionKey, locale);
	}
}

package org.aidas.app.services;

import java.util.Locale;

import org.aidas.app.request.dto.LoginRequestDTO;
import org.aidas.app.response.dto.GenericResponse;
import org.aidas.app.response.dto.LoginResponseDTO;

public interface AuthenticationService {
	
	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO, Locale locale);
	
	public GenericResponse logout(String sessionKey, Locale locale);

}
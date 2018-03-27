package org.aidas.app.controller;

import javax.validation.Valid;

import org.aidas.app.constant.PathConstant;
import org.aidas.app.util.CommonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = PathConstant.UTIL)
public class UtilController {
	
	@CrossOrigin(methods = RequestMethod.POST)
	@RequestMapping(value = PathConstant.AIDAS_BASE64_ENCRYPT_SERVICE, method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Provide the string to encrypt", notes = "This API is to encrypt a string")
	public String encryptData(@RequestBody @Valid String strToEncrypt){ 
		return CommonUtil.base64Encrypt(strToEncrypt);
	}
	
	@CrossOrigin(methods = RequestMethod.POST)
	@RequestMapping(value = PathConstant.AIDAS_BASE64_DECRYPT_SERVICE, method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Provide the string to decrypt", notes = "This API is to decrypt a string")
	public String decryptData(@RequestBody @Valid String strToDecrypt){ 
		return CommonUtil.base64Decrypt(strToDecrypt);
	}
}

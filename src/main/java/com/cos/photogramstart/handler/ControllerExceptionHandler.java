package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CustomValidationException.class) // RuntimeException이 발동하는 모든 익셉션을 가로챈다.
	public String validationException(CustomValidationException e) {
		// CMRespDto, Script 비교
		// 1. 클라이언트에게 응답할 때는 Script가 좋음
		// 2. Ajax통신 - CMRespDto (응답을 개발자가 받는 것)
		// 3. Android 통신 - CMRespDto (응답을 개발자가 받는 것)
		return Script.back(e.getErrorMap().toString());
	}
	
}

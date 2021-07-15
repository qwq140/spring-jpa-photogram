package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException {

	// 객체를 구분할 떄 사용
	private static final long serialVersionUID = 1L;

	private Map<String, String> errorMap;
	
	public CustomValidationException(String message,Map<String, String> errorMap ) {
		super(message); // 메시지는 부모에
		this.errorMap = errorMap;
	}
	
	public Map<String, String> getErrorMap(){
		return errorMap;
	}
}

package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomException extends RuntimeException {

	// 객체를 구분할 떄 사용
	private static final long serialVersionUID = 1L;

	
	public CustomException(String message) {
		super(message); // 메시지는 부모에
	}

}

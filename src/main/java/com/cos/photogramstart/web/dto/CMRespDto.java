package com.cos.photogramstart.web.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CMRespDto<T> {
	private int code; // 1 : 성공, -1 : 실패
	private String message;
	private T data; // Map이 아닌 데이터를 리턴하고싶은 경우도 있음 -> 제네릭을 사용
}

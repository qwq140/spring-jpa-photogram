package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 걸려있는 필드를 DI 할때 사용 (final 걸린 필드의 생성자를 생성함)
@Controller // 1. IoC 등록 2. 파일을 리턴하는 컨트롤러
public class AuthController {

	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	private final AuthService authService;
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	// 회원가입 버튼을 클릭을 하면 -> /auth/signup -> /auth/signin
	// 회원가입버튼 x -> CSRF 토큰이 활성화 되어있어서 안됨
	@PostMapping("/auth/signup")
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { // key=value (x-www-form-urlencoded)
		log.info(signupDto.toString());
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new CustomValidationException("유효성검사 실패함",errorMap);
		} else {
			// User <- SignupDto
			User user = signupDto.toEntity();
			log.info(user.toString());
			User userEntity = authService.회원가입(user);
			System.out.println(userEntity);
			return "auth/signin";
		}
		
	}
	
}

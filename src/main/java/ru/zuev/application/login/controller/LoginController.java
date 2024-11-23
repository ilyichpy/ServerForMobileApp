package ru.zuev.application.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zuev.application.data.dto.UserDto;
import ru.zuev.application.emailCode.dto.EmailResponse;
import ru.zuev.application.login.dto.LoginRequest;
import ru.zuev.application.login.service.LoginService;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class LoginController {
	private final LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody LoginRequest loginRequest) {
		UserDto userDto = null;
		try {
			 userDto = loginService.checkLoginInfo(loginRequest);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		return ResponseEntity.status(200).body(userDto);
	}
}

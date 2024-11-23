package ru.zuev.application.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.zuev.application.data.dto.UserDto;
import ru.zuev.application.emailCode.repository.EmailRepository;
import ru.zuev.application.login.dto.LoginRequest;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final EmailRepository emailRepository;
	public UserDto checkLoginInfo(LoginRequest loginRequest) {
		try {
			UserDto user = emailRepository.findUserDtoByEmail(loginRequest.getEmail());
			if (user.getPassword().equals(loginRequest.getPassword())) {
				return user;
			} else {
				throw new RuntimeException("fail");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

package ru.zuev.application.emailCode.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.zuev.application.emailCode.dto.EmailRequest;
import ru.zuev.application.emailCode.repository.EmailRepository;

@Service
@RequiredArgsConstructor
public class EmailVerifyService {
	private final EmailRepository emailRepository;

	public int verify(EmailRequest emailDto) {
		var user = emailRepository.findUserDtoByEmail(emailDto.getEmail());
		if (user.getCode().equals(emailDto.getCode())) {
			return HttpStatus.OK.value();
		} else {
			throw new RuntimeException("неверный пароль");
		}
	}
}

package ru.zuev.application.emailCode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zuev.application.emailCode.dto.EmailRequest;
import ru.zuev.application.emailCode.dto.EmailResponse;
import ru.zuev.application.emailCode.service.EmailSenderService;
import ru.zuev.application.emailCode.service.EmailVerifyService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmailController {

	private final EmailSenderService emailSenderService;
	private final EmailVerifyService emailVerifyService;

	@PostMapping("/send_code")
	@ResponseStatus(HttpStatus.OK)
	public EmailResponse generateAndSendEmail(@RequestBody EmailRequest userEmail) {
		int code = emailSenderService.sendMessage(userEmail);
		return EmailResponse.builder()
				.status(code)
				.build();
	}

	@PostMapping("/verify")
	public ResponseEntity<EmailResponse> verifyUser(@RequestBody EmailRequest userEmail) {
		try {
			int code = emailVerifyService.verify(userEmail);
			return ResponseEntity.ok(
					EmailResponse.builder()
							.status(code)
							.build()
			);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(
							EmailResponse.builder()
									.status(500) // Тело ответа
									.build()
					);
		}
	}
}

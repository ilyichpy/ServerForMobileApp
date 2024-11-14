package ru.zuev.application.emailCode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.zuev.application.emailCode.dto.EmailDto;
import ru.zuev.application.emailCode.dto.EmailResponse;
import ru.zuev.application.emailCode.service.EmailSenderService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("v1/api/email")
public class EmailController {

	private final EmailSenderService emailSenderService;

	public EmailController() {
		this.emailSenderService = new EmailSenderService();
	}

	@PostMapping("/send_code")
	@ResponseStatus(HttpStatus.OK)
	public EmailResponse generateAndSendEmail(@RequestBody EmailDto userEmail) {
		int code = emailSenderService.sendMessage(userEmail);
		return EmailResponse.builder()
				.status(code)
				.build();
	}
}

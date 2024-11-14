package ru.zuev.application.emailCode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zuev.application.emailCode.service.EmailCodeGeneratorService;
import ru.zuev.application.emailCode.service.EmailSenderService;

import javax.mail.MessagingException;

@Controller
@RequestMapping("v1/api/email/generate_code")
public class EmailController {

	private EmailSenderService emailSenderService;

	public EmailController() {
		this.emailSenderService = new EmailSenderService();
	}

	@GetMapping("/send_code")
	public String generateAndSendEmail(@RequestBody String userEmail) throws MessagingException {
		emailSenderService.sendMessage(userEmail);
		return "true";
	}
}

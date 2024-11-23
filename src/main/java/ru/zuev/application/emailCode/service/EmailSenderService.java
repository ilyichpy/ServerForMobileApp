package ru.zuev.application.emailCode.service;

import com.squareup.okhttp.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.zuev.application.data.dto.UserDto;
import ru.zuev.application.emailCode.dto.EmailRequest;
import ru.zuev.application.emailCode.repository.EmailRepository;

import java.io.IOException;

@Service
@Slf4j
@AllArgsConstructor
public class EmailSenderService {

	private final EmailRepository emailRepository;

	public int sendMessage(EmailRequest email) {
		String code = EmailCodeGeneratorService.generateCode();
		UserDto userDto = UserDto.builder()
						.password(email.getPassword())
						.email(email.getEmail())
						.code(code).build();
		log.info("user email: {}, user code: {}", email, code);
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"from\":{\"email\":\"hello@demomailtrap.com\",\"name\":\"Код регистрации для приложения\"},\"to\":[{\"email\":\"" + email.getEmail() + "\"}],\"subject\":\"Код регистрации\",\"text\":\"Ваш код регистрации: " + code + "\",\"category\":\"Integration Test\"}");
		Request request = new Request.Builder()
		    .url("https://bulk.api.mailtrap.io/api/send")
		    .method("POST", body)
		    .addHeader("Authorization", "Bearer 6ed957d1b4cd99d648e79b7e7b0410a8")
		    .addHeader("Content-Type", "application/json")
		    .build();

		try {
			Response response = client.newCall(request).execute();
			if (response.code() == 200) {
				emailRepository.save(userDto);
			}
			return response.code();
		} catch (IOException e) {
			log.info("Проблема при отправке запроса");
			return 500;
		}

	}
}

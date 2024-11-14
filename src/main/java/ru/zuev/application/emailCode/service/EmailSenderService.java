package ru.zuev.application.emailCode.service;

import com.squareup.okhttp.*;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.zuev.application.emailCode.dto.EmailDto;

import javax.mail.*;
import java.io.IOException;

@Service
@NoArgsConstructor
@Slf4j
public class EmailSenderService {

	public int sendMessage(EmailDto email) {
		String code = EmailCodeGeneratorService.generateCode();
		log.info("user email: {}, user code: {}", email, code);
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"from\":{\"email\":\"hello@demomailtrap.com\",\"name\":\"Код регистрации для приложения\"},\"to\":[{\"email\":\"" + email.getUserEmail() + "\"}],\"subject\":\"Код регистрации\",\"text\":\"Ваш код регистрации: " + code + "\",\"category\":\"Integration Test\"}");
		Request request = new Request.Builder()
		    .url("https://bulk.api.mailtrap.io/api/send")
		    .method("POST", body)
		    .addHeader("Authorization", "Bearer 6ed957d1b4cd99d648e79b7e7b0410a8")
		    .addHeader("Content-Type", "application/json")
		    .build();

		try {
			Response response = client.newCall(request).execute();
			return response.code();
		} catch (IOException e) {
			log.info("Проблема при отправке запроса");
			return 500;
		}

	}
}

package ru.zuev.application.emailCode.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.*;
import java.io.IOException;

@Service
@NoArgsConstructor
public class EmailSenderService {
	public void sendMessage(String email) {
		// provide recipient's email ID
		String code = EmailCodeGeneratorService.generateCode();
		OkHttpClient client = new OkHttpClient();
		com.squareup.okhttp.MediaType mediaType = com.squareup.okhttp.MediaType.parse("application/json");
		com.squareup.okhttp.RequestBody body = RequestBody.create(mediaType,
				"{\"from\":{\"email\":\"ilyaszuev25@gmail.com\"," +
						"\"name\":\"Код авторизации\"}," +
						"\"to\":[{\"email\":\"" + email + "\"}]," +
						"\"subject\":\"Код аторизации\"," +
						"\"text\":\"Ваш код аторизации, " + code + "\n Никому его не сообщайте\"" +
						"\"category\":\"Integration Test\"}");
		Request request = new Request.Builder()
		    .url("https://send.api.mailtrap.io/api/send")
		    .method("POST", body)
		    .addHeader("Authorization", "Bearer f49125a95bc053a1553cf2e9c36892fb")
		    .addHeader("Content-Type", "application/json")
		    .build();
		try {
			Response response = client.newCall(request).execute();
		} catch (IOException e) {
			System.out.println("fail");
		}
	}
}

package ru.zuev.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zuev.application.emailCode.service.EmailCodeGeneratorService;

@SpringBootApplication
public class BackendJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendJavaApplication.class, args);
		System.out.println(EmailCodeGeneratorService.generateCode());
	}

}

package ru.zuev.application.emailCode.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailCodeGeneratorService {
	public static String generateCode() {
		Random random = new Random();
		return String.valueOf(random.nextInt(1000, 10000));
	}
}

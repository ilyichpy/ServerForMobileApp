package ru.zuev.application.emailCode.dto;

import lombok.Data;

@Data
public class EmailRequest {
	private String email;
	private String password;
	private String code;
}

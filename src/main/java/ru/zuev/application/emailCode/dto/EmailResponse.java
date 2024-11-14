package ru.zuev.application.emailCode.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailResponse {
	private int status;
}

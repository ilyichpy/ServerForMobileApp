package ru.zuev.application.emailCode;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
	public SmtpAuthenticator() {

		super();
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		String username = "ilyaszuev25@gmail.com";
		String password = "zuev022504";
		if ((username != null) && (username.length() > 0) && (password != null)
				&& (password.length() > 0)) {

			return new PasswordAuthentication(username, password);
		}

		return null;
	}
}

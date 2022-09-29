package com.project.shop.global.error.handler;

import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

	UNKNOWN_SERVER_ERROR("USE001", "Unknown server error.", SERVICE_UNAVAILABLE);

	private final String code;
	private final String message;
	private final HttpStatus httpStatus;

	ErrorCode(String code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
}

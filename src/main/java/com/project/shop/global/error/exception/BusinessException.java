package com.project.shop.global.error.exception;

import com.project.shop.global.error.handler.ErrorCode;

import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {
	private final ErrorCode errorCode;

	protected BusinessException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	protected BusinessException(ErrorCode errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}
}

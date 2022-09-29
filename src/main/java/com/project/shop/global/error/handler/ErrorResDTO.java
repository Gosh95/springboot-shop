package com.project.shop.global.error.handler;

import java.util.Collections;
import java.util.List;

import org.springframework.validation.BindingResult;

public record ErrorResDTO(
	String code,
	String message,
	List<CustomFieldError> errors
) {

	public static ErrorResDTO from(ErrorCode errorCode) {
		return new ErrorResDTO(errorCode.getCode(), errorCode.getMessage(), Collections.emptyList());
	}

	public static ErrorResDTO of(ErrorCode errorCode, BindingResult bindingResult) {
		return new ErrorResDTO(errorCode.getCode(), errorCode.getMessage(), CustomFieldError.from(bindingResult));
	}
}

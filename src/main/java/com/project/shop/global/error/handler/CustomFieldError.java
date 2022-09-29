package com.project.shop.global.error.handler;

import java.util.Collections;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public record CustomFieldError(
	String fieldName,
	Object inputValue,
	String cause
) {

	public static List<CustomFieldError> from(BindingResult bindingResult) {
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		return fieldErrors.isEmpty()
			? Collections.emptyList()
			: fieldErrors.stream()
			.map(e -> new CustomFieldError(e.getField(), e.getRejectedValue(), e.getDefaultMessage()))
			.toList();
	}
}

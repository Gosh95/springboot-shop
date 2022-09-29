package com.project.shop.global.error.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResMapper {

	public static ResponseEntity<ErrorResDTO> from(ErrorCode errorCode) {
		return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResDTO.from(errorCode));
	}

	public static ResponseEntity<ErrorResDTO> of(ErrorCode errorCode, BindingResult bindingResult) {
		return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResDTO.of(errorCode, bindingResult));
	}
}

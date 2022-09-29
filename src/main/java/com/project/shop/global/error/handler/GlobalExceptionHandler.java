package com.project.shop.global.error.handler;

import static com.project.shop.global.error.handler.ErrorCode.UNKNOWN_SERVER_ERROR;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResDTO> handleException(Exception ex) {
		log.error("Got Exception: {}", ex.getMessage(), ex);
		return ErrorResMapper.from(UNKNOWN_SERVER_ERROR);
	}
}

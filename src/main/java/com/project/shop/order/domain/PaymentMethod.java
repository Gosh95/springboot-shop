package com.project.shop.order.domain;

import lombok.Getter;

@Getter
public enum PaymentMethod {

	CREDIT_CARD("신용카드"),
	CASH_DEPOSIT("무통장 입금"),
	KAKAO_PAY("카카오 페이"),
	NAVER_PAY("네이버 페이");

	private final String method;

	PaymentMethod(String method) {
		this.method = method;
	}
}

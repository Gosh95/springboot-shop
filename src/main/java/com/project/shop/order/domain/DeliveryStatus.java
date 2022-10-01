package com.project.shop.order.domain;

import lombok.Getter;

@Getter
public enum DeliveryStatus {

	PAYMENT_COMPLETED("결제 완료"),
	DELIVERY_PREPARING("배송 준비 중"),
	DELIVERY_STARTED("배송 시작"),
	DELIVERY_COMPLETED("배송 완료"),
	PURCHASE_CONFIRMED("구매 확정"),
	ORDER_CANCELED("주문 취소"),
	REFUND_COMPLETED("환불 완료");

	private final String type;

	DeliveryStatus(String type) {
		this.type = type;
	}
}

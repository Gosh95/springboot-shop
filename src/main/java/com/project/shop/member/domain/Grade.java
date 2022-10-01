package com.project.shop.member.domain;

import lombok.Getter;

@Getter
public enum Grade {
	BRONZE(1.0f),
	SILVER(1.5f),
	GOLD(2.0f),
	PLATINUM(2.5f),
	DIAMOND(3.0f);

	private final float discountRate;

	Grade(float discountRate) {
		this.discountRate = discountRate;
	}
}

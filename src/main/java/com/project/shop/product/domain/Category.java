package com.project.shop.product.domain;

import lombok.Getter;

@Getter
public enum Category {

	FOOD("사료"),
	NUTRIENTS("영양제"),
	SNACK("간식"),
	CLOTH("옷"),
	ACCESSORY("악세사리"),
	TOY("장난감");

	private final String type;

	Category(String type) {
		this.type = type;
	}
}

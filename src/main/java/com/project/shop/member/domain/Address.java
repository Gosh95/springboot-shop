package com.project.shop.member.domain;

import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class Address {

	@Column(nullable = false, length = 16)
	private String city;

	@Column(nullable = false, length = 24)
	private String roadAddr;

	@Column(nullable = false, length = 50)
	private String detailAddr;

	@Column(nullable = false, length = 6)
	private String postalCode;

	@Builder
	public Address(String city, String roadAddr, String detailAddr, String postalCode) {
		this.city = city;
		this.roadAddr = roadAddr;
		this.detailAddr = detailAddr;
		this.postalCode = postalCode;
	}
}

package com.project.shop.order.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.project.shop.global.common.BaseTimeEntity;
import com.project.shop.member.domain.AddressBook;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Delivery extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(unique = true, updatable = false, length = 16)
	private String trackingNumber;

	@Column(nullable = false, length = 24)
	private DeliveryStatus deliveryStatus;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "address_book_id")
	private AddressBook addressBook;

	@Builder
	public Delivery(
		String trackingNumber,
		DeliveryStatus deliveryStatus,
		AddressBook addressBook
	) {
		this.trackingNumber = trackingNumber;
		this.deliveryStatus = deliveryStatus;
		this.addressBook = addressBook;
	}
}

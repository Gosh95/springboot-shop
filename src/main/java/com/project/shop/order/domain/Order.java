package com.project.shop.order.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.shop.global.common.BaseTimeEntity;
import com.project.shop.member.domain.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = PROTECTED)
public class Order extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
	private UUID orderCode;

	@Column(nullable = false)
	private Long totalPrice;

	@Enumerated(STRING)
	@Column(nullable = false, length = 16)
	private PaymentMethod paymentMethod;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "order")
	private final List<OrderItem> orderItems = new ArrayList<>();

	@Builder
	public Order(
		UUID orderCode,
		Long totalPrice,
		PaymentMethod paymentMethod,
		Member member,
		List<OrderItem> orderItems
	) {
		this.orderCode = orderCode;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
		this.member = member;
		addOrderProducts(orderItems);
	}

	private void addOrderProducts(List<OrderItem> orderItems) {
		orderItems.forEach(o -> o.setOrder(this));
		this.orderItems.addAll(orderItems);
	}
}

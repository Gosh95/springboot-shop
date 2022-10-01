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
import com.project.shop.product.domain.Item;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class OrderItem extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false)
	private Integer orderQuantity;

	@Column(nullable = false)
	private Long orderPrice;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "item_id")
	private Item item;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;

	public OrderItem(Integer orderQuantity, Long orderPrice, Item item) {
		this.orderQuantity = orderQuantity;
		this.orderPrice = orderPrice;
		this.item = item;
	}

	protected void setOrder(Order order) {
		this.order = order;
	}
}

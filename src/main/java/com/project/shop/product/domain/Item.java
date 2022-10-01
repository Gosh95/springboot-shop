package com.project.shop.product.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

import com.project.shop.global.common.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type", discriminatorType = STRING)
@NoArgsConstructor(access = PROTECTED)
public class Item extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false, length = 24)
	private String name;

	@Column(nullable = false, length = 160)
	private String thumbnailImageUrl;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Integer stockQuantity;

	@OneToMany(mappedBy = "item", cascade = ALL, orphanRemoval = true)
	private final List<ItemImage> itemImages = new ArrayList<>();
}

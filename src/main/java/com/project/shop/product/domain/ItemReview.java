package com.project.shop.product.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.project.shop.global.common.BaseTimeEntity;
import com.project.shop.member.domain.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class ItemReview extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false, length = 300)
	private String contents;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "parent_id")
	private ItemReview parent;

	@OneToMany(mappedBy = "parent", orphanRemoval = true)
	private final List<ItemReview> children = new ArrayList<>();

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "item_id")
	private Item item;

	@Builder
	public ItemReview(String contents, ItemReview parent, Member member, Item item) {
		this.contents = contents;
		this.parent = parent;
		this.member = member;
		this.item = item;
	}
}

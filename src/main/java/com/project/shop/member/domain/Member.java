package com.project.shop.member.domain;

import static com.project.shop.member.domain.Grade.BRONZE;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.project.shop.global.common.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false, updatable = false)
	private Long id;

	@Column(nullable = false, updatable = false, length = 16)
	private String name;

	@Column(unique = true, nullable = false, length = 20)
	private String nickname;

	@Column(nullable = false, length = 160)
	private String profileImageUrl;

	@Column(unique = true, nullable = false, length = 16)
	private String phoneNumber;

	@Embedded
	private Account account;

	@Enumerated(STRING)
	@Column(nullable = false, length = 12)
	private Grade grade;

	@Enumerated(STRING)
	@ElementCollection
	@Column(name = "role", nullable = false, length = 16)
	@CollectionTable(name = "member_roles", joinColumns = @JoinColumn(name = "member_id"))
	private final Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
	private final List<AddressBook> addressBooks = new ArrayList<>();

	@Builder
	public Member(
		String name,
		String nickname,
		String profileImageUrl,
		String phoneNumber,
		Account account,
		Role role,
		AddressBook addressBook
	) {
		this.name = name;
		this.nickname = nickname;
		this.profileImageUrl = profileImageUrl;
		this.phoneNumber = phoneNumber;
		this.account = account;
		this.grade = BRONZE;
		this.roles.add(role);
		addAddressBook(addressBook);
	}

	public void addAddressBook(AddressBook addressBook) {
		addressBook.setMember(this);
		this.addressBooks.add(addressBook);
	}
}

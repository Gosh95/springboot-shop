package com.project.shop.member.domain;

import static lombok.AccessLevel.PROTECTED;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = PROTECTED)
public class Account {

	@Column(unique = true, nullable = false, updatable = false, length = 30)
	private String email;

	@Column(nullable = false, length = 60)
	private String password;

	@Column(nullable = false)
	private LocalDateTime lastLoginAt;

	@Column(nullable = false)
	private boolean isLocked;

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
		this.lastLoginAt = LocalDateTime.now();
		this.isLocked = false;
	}
}

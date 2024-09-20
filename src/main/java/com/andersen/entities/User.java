package com.andersen.entities;

import java.time.LocalDateTime;

public abstract class User extends AbstractEntity {

	private String name;

	private LocalDateTime creationDate;

	protected Ticket ticket;

	public User(Ticket ticket) {
		this.ticket = ticket;
	}

	public abstract void printRole();

	public String getName() {
		return name;
	}
}

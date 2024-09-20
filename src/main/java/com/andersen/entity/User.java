package com.andersen.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class User extends AbstractEntity {

	protected String name;

	protected LocalDateTime creationDate;

	protected List<Ticket> tickets;

	public User() {
	}

	public User(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public User(String name, LocalDateTime creationDate) {
		this.name = name;
		this.creationDate = creationDate;
	}

	public abstract void printRole();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void addTicket(Ticket ticket) {
		if (tickets == null) {
			tickets = new ArrayList<>();
		}

		tickets.add(ticket);

		ticket.setUser(this);
	}
}

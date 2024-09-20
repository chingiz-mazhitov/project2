package com.andersen.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Client extends User {

	public Client() {
	}

	public Client(String name, LocalDateTime creationDate) {
		super(name, creationDate);
	}

	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

	public List<Ticket> getTicket() {
		return super.tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Client{" +
				"name='" + name + '\'' +
				", creationDate=" + creationDate +
				", tickets=" + tickets +
				", id=" + id +
				'}';
	}
}

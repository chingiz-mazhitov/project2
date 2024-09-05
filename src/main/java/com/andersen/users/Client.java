package com.andersen.users;

import com.andersen.Ticket;

public class Client extends User {

	public Client(Ticket ticket) {
		super(ticket);
	}

	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

	public Ticket getTicket() {
		return super.ticket;
	}
}

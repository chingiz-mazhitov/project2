package com.andersen.users;

import com.andersen.Ticket;

public class Client extends User {

	public Client(Ticket ticket) {
		super(ticket);
	}

	@Override
	public int getId() {
		return super.id;
	}

	@Override
	public void setId(int id) {
		super.id = id;
	}

	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

	public Ticket getTicket() {
		return super.ticket;
	}
}

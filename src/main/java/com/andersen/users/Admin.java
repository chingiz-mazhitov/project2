package com.andersen.users;

import com.andersen.Ticket;

public class Admin extends User {

	public Admin(Ticket ticket) {
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

	public boolean checkTicket(Ticket ticket) {
		return ticket.equals(super.ticket);
	}
}

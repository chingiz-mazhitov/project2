package com.andersen.entities;

public class Admin extends User {

	public Admin(Ticket ticket) {
		super(ticket);
	}

	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

	public boolean checkTicket(Ticket ticket) {
		return ticket.equals(super.ticket);
	}
}

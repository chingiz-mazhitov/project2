package com.andersen.users;

import com.andersen.Identifiable;
import com.andersen.Ticket;

public class Client extends User implements Identifiable {

	private int id;

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

	public Ticket getTicket() {
		return super.ticket;
	}
}

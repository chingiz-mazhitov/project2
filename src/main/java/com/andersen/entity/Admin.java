package com.andersen.entity;

import java.time.LocalDateTime;

public class Admin extends User {

	public Admin(String name, LocalDateTime creationDate) {
		super(name, creationDate);
	}

	@Override
	public void printRole() {
		System.out.println("Role: " + this.getClass().getSimpleName());
	}

//	public boolean checkTicket(Ticket ticket) {
//		return ticket.equals(super.tickets);
//	}
}

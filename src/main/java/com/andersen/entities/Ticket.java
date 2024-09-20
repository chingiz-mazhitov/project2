package com.andersen.entities;

import com.andersen.bus.TicketType;

import java.time.LocalDateTime;

public class Ticket extends AbstractEntity {

	private TicketType ticketType;

	private LocalDateTime creationDate;



	public Ticket() {
	}

	public Ticket(TicketType ticketType, LocalDateTime creationDate) {
		this.ticketType = ticketType;
		this.creationDate = creationDate;
	}

	// define overloaded share() methods since static polymorphism is chosen
	public void share(String phoneNumber) {
		System.out.println("Sharing ticket via phone");
		System.out.printf("phone: %s, ticket details: %s\n", phoneNumber, this);
	}

	public void share(String phoneNumber, String email) {
		System.out.println("Sharing ticket via phone and email");
		System.out.printf("phone: %s, email: %s ticket details: %s\n", phoneNumber, email, this);
	}

	@Override
	public void print() {
		System.out.printf("""
				Ticket details
				Id: %d
				Time: %d""", id, creationDate);
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
}

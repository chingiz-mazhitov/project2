package com.andersen.entity;

import com.andersen.bus.TicketType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket extends AbstractEntity {

	private TicketType ticketType;

	private LocalDateTime creationDate;

	private User user;


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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDate = creationDate.format(formatter);
		System.out.printf("""
				Ticket details
				Id: %d
				Time: %d""", id, formattedDate);
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Ticket ticket = (Ticket) o;
		return ticketType == ticket.ticketType && Objects.equals(creationDate, ticket.creationDate) && Objects.equals(user, ticket.user);
	}

	@Override
	public int hashCode() {
		int result = Objects.hashCode(ticketType);
		result = 31 * result + Objects.hashCode(creationDate);
		result = 31 * result + Objects.hashCode(user);
		return result;
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"ticketType=" + ticketType +
				", creationDate=" + creationDate +
				", id=" + id +
				'}';
	}
}

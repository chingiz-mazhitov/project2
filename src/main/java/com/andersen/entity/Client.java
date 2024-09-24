package com.andersen.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Client extends User {


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
}

package com.andersen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@NoArgsConstructor
@ToString(callSuper = true)
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

	public void addTicket(Ticket ticket) {
		if (tickets == null) {
			tickets = new ArrayList<>();
		}

		tickets.add(ticket);

		ticket.setClient(this);
	}
}

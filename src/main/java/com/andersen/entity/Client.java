package com.andersen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
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
@NamedQuery(name = Client.FIND_WITH_TICKETS, query = """
				select distinct c from Client c
				left join fetch c.tickets t
				where c.id = :id""")
public class Client extends User {

	public static final String FIND_WITH_TICKETS = "Client.findWithTickets";


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

package com.andersen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class User extends AbstractEntity {

	@NonNull
	@Column(name = "name")
	protected String name;

	@NonNull
	@Column(name = "creation_date")
	protected LocalDateTime creationDate;

	protected List<Ticket> tickets;

	public User(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public abstract void printRole();

	public void addTicket(Ticket ticket) {
		if (tickets == null) {
			tickets = new ArrayList<>();
		}

		tickets.add(ticket);

		ticket.setUser(this);
	}
}

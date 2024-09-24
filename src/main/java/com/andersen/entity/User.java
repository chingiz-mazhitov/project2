package com.andersen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@MappedSuperclass
@Setter
@Getter
@ToString(exclude = "tickets")
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class User extends AbstractEntity {

	@NonNull
	@Column(name = "name")
	protected String name;

	@NonNull
	@Column(name = "creation_date")
	protected LocalDateTime creationDate;

	@OneToMany(mappedBy = "client", fetch = LAZY, cascade = ALL, orphanRemoval = true)
	protected List<Ticket> tickets;

	public User(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public abstract void printRole();

}

package com.andersen.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity(name = "app_user")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class User extends AbstractEntity {

	@NonNull
	@Column(name = "name")
	protected String name;

	@NonNull
	@Column(name = "creation_date")
	protected LocalDateTime creationDate;

	@OneToMany(mappedBy = "user", fetch = LAZY, cascade = ALL, orphanRemoval = true)
	@JsonManagedReference
	protected List<Ticket> tickets;

	public void addTicket(Ticket ticket) {
		if (tickets == null) {
			tickets = new ArrayList<>();
		}

		tickets.add(ticket);

		ticket.setUser(this);
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", creationDate=" + creationDate +
				", id=" + id +
				'}';
	}
}

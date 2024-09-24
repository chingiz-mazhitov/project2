package com.andersen.entity;

import com.andersen.bus.TicketType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Ticket extends AbstractEntity {

	@NonNull
	@Column(name = "ticket_type")
	private TicketType ticketType;

	@NonNull
	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	private User user;

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
}

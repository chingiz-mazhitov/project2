package com.andersen.entity;

import com.andersen.bus.TicketType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
@ToString(callSuper = true, exclude = "client")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	@Column(name = "ticket_type")
	@JdbcTypeCode(SqlTypes.NAMED_ENUM)
	TicketType ticketType;

	@Column(name = "creation_date")
	LocalDateTime creationDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	Client client;

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

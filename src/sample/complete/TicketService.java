package sample.complete;

import java.time.Instant;
import java.util.Random;

public class TicketService {
	public static void main(String[] args) {

		long unixTimestamp = Instant.now().getEpochSecond();
		System.out.println("-".repeat(80));

		// empty
		Ticket ticketEmpty = new Ticket();
		System.out.println(ticketEmpty);
		System.out.println("-".repeat(80));

		// full
		Ticket ticket = new Ticket(1000, "City Center",
				1, unixTimestamp, false, 'A', 10.200);
		System.out.println(ticket);
		System.out.println("-".repeat(80));

		// limited
		Ticket ticket1 = new Ticket("Couchella", 123, unixTimestamp);
		System.out.println(ticket1);


	}
}
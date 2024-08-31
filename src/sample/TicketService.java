package sample;

import java.time.Instant;
import java.util.Arrays;

public class TicketService {
	public static void main(String[] args) {

		long unixTimestamp = Instant.now().getEpochSecond();
		long timestamp = System.currentTimeMillis() / 1000;
		long timestampNano = System.nanoTime();
		System.out.println(timestamp);
		System.out.println(unixTimestamp);

		System.out.println("-".repeat(80));

		var charArray = "ABCDEFGHIJ".toCharArray();

		Ticket ticket = new Ticket(1000, "City Center", 999, unixTimestamp, true, 'A', 10.200);

		System.out.println(ticket);

		Ticket ticket1 = new Ticket("Couchella", 123, unixTimestamp);
		System.out.println(ticket1);

//		System.out.println("-".repeat(80));
//		int variable = 003;
//		System.out.println(variable);

//		for (int i = 1; i <= 999; i++) {
//			String code = String.format("%03d", i);
//			System.out.println("Code: " + code);
//		}

	}
}
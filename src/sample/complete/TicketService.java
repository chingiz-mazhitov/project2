package sample.complete;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class TicketService {

	private static Map<Integer, Ticket> tickets;

	public static void main(String[] args) {

		tickets = new HashMap<>();

		// generate 10 tickets
		IntStream.rangeClosed(1, 10)
				.forEach(ticket -> {
					long unixTimestamp = System.currentTimeMillis() / 1000;
					tickets.put(ticket, new Ticket("Event-" + ticket, ticket, unixTimestamp));

					try {
						// Sleep for 500 ms
						Thread.sleep(500);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				});

//		for (var value: tickets.values()) {
//			System.out.println(value);
//		}

		var ticket = getTicketById(1);
		System.out.println(ticket);

	}

	private static Ticket getTicketById(int id) {
		return tickets.get(id);
	}

}
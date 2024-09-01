package sample.complete;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class TicketService {


	public static void main(String[] args) {

		Map<Integer, Ticket> tickets = new HashMap<>();

		// generate 10 tickets
		IntStream.rangeClosed(1, 10)
				.forEach(i -> {
					long unixTimestamp = System.currentTimeMillis() / 1000;
					tickets.put(i, new Ticket("Event-" + i, i, unixTimestamp));

					try {
						// Sleep for 500 ms
						Thread.sleep(500);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				});

		for (var value: tickets.values()) {
			System.out.println(value);
		}

	}


}
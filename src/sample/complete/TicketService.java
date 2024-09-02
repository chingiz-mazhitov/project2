package sample.complete;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
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

        var ticket = getTicketById(1);
        System.out.println(ticket);
//testing getTicketsByStadiumSector function
        Map<Integer, Ticket> ticketByStadiumSector = getTicketsByStadiumSector('A');
        toStringMap(ticketByStadiumSector);
    }
    private static Ticket getTicketById(int id) {
        return tickets.get(id);
    }

    /**
     * This function iterates over all tickets stored in the tickets map and returns
     * a new map containing only those tickets that belong to the specified sector.
     */
    private static Map<Integer, Ticket> getTicketsByStadiumSector(char sector) {
        Map<Integer, Ticket> result = new HashMap<>();
        if (tickets == null) {
            return result;
        }
        return tickets.entrySet().stream()
                .filter(entry -> entry.getValue().getSector() == sector)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    /**
     * Prints the contents of a map (Map) to the console.
     */
    private static <K, V> void toStringMap(Map<K, V> map) {
        if (map == null || map.isEmpty()) {
            System.out.println("The map is empty or null.");
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("ID: " + entry.getKey());
            System.out.println("Ticket: " + entry.getValue());
        }
    }
}
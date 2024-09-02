package sample.complete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<Ticket> ticketsByStadiumSector = getTicketsByStadiumSector('A');
        printTickets(ticketsByStadiumSector);
    }
    private static Ticket getTicketById(int id) {
        return tickets.get(id);
    }
    /**
     * This function iterates over all tickets stored in the tickets map and returns
     * a new List containing only those tickets that belong to the specified sector.
     */
    private static List<Ticket> getTicketsByStadiumSector(char sector) {
        List<Ticket> result = new ArrayList<>();
        if (tickets == null) {
            return result;
        }
        return tickets.entrySet().stream()
                .filter(entry -> entry.getValue().getSector() == sector)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
    /**
     * Prints the contents of a list of tickets to the console.
     */
    private static void printTickets(List<Ticket> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            System.out.println("The list is empty or null.");
            return;
        }
        System.out.println("List:");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
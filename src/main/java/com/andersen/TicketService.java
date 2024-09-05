package com.andersen;

import com.andersen.users.Admin;
import com.andersen.users.Client;
import com.andersen.users.User;

import java.util.*;

public class TicketService {

    private static List<Ticket> tickets;

    public static void main(String[] args) {

        System.out.println("-".repeat(80));
        tickets = new ArrayList<>();

        List<Character> sectorList = new ArrayList<>();
        sectorList.addAll(List.of('A', 'B', 'C'));
        Collections.shuffle(sectorList);

        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            long timeStamp = System.currentTimeMillis();
            boolean isPromo = random.nextBoolean();
            int ticketId = i;
            Character sector = sectorList.get(ticketId % sectorList.size());
            tickets.add(new Ticket(ticketId, "Hall", 101, timeStamp, isPromo, sector, 10.5));
        }

        // testing getTicketsBySector function
        List<Ticket> ticketsByStadiumSector = getTicketsBySector('A');
        printTickets(ticketsByStadiumSector);
        System.out.println("-".repeat(80));

        // demonstrate static polymorphism for share() method
        String phone = "15705143163";
        String email = "chingiz.mazhitov56@gmail.com";
        Ticket ticket2 = getTicketById(2);

        ticket2.share(phone);
        ticket2.share(phone, email);

        // demonstrate dynamic polymorphism for Client and Admin subclasses
        User client = new Client();
        client.printRole();

        User admin = new Admin();
        admin.printRole();

        Ticket ticket = new Ticket();

    }
    private static Ticket getTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                System.out.println("Ticket with #id " + id + " is found!");
                return ticket;
            }
        }
        System.out.println("Ticket is not found!");
        return null;
    }
    /**
     * This function iterates over all tickets stored in the tickets map and returns
     * a new List containing only those tickets that belong to the specified sector.
     */
    private static List<Ticket> getTicketsBySector(char sector) {
        List<Ticket> result = new ArrayList<>();
        if (tickets == null) {
            return result;
        }
        for (Ticket ticket : tickets) {
            if (ticket.getSector() == sector) {
                result.add(ticket);
            }
        }
        return result;
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
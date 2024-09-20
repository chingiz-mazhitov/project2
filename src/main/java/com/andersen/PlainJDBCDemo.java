package com.andersen;

import com.andersen.bus.TicketType;
import com.andersen.dao.UserTicketDaoImpl;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;

import java.time.LocalDateTime;

public class PlainJDBCDemo {

	private static UserTicketDaoImpl userTicketDao = new UserTicketDaoImpl();

	public static void main(String[] args) {

		String name = "John";
		LocalDateTime dt = LocalDateTime.now();

		User client = new Client(name, dt);

		var persistedClient = userTicketDao.saveUser(client);

		System.out.println(client);
		System.out.println(persistedClient);

		Ticket ticket = new Ticket(TicketType.WEEK, LocalDateTime.now());

		var userFromDB = userTicketDao.findUserById(1);

		System.out.println(userFromDB);

		userFromDB.addTicket(ticket);

		System.out.println(ticket);

		userTicketDao.saveTicket(ticket);

		Ticket ticketFromDB = userTicketDao.findTicketById(1);
		System.out.println(ticketFromDB);

		var findTicketByUser = userTicketDao.findTicketsByUserId(1);
		System.out.println(findTicketByUser);

		var firstTicket = findTicketByUser.getFirst();
		firstTicket.setTicketType(TicketType.DAY);

		var updateTicketType = userTicketDao.updateTicketType(firstTicket);
		var updatedTicket = userTicketDao.findTicketById(firstTicket.getId());

		System.out.println(updatedTicket);


	}
}

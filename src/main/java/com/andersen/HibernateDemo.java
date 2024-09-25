package com.andersen;

import com.andersen.bus.TicketType;
import com.andersen.dao.UserTicketDao;
import com.andersen.dao.UserTicketDaoImpl;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class HibernateDemo {

	private static final UserTicketDao USER_TICKET_DAO = new UserTicketDaoImpl();

	public static void main(String[] args) {

		// Insert user
		Client user1 = new Client();
		user1.setName("Ernest");
		user1.setCreationDate(LocalDateTime.now());

		// add ticket
		Ticket ticket1 = new Ticket();
		ticket1.setTicketType(TicketType.WEEK);
		ticket1.setCreationDate(LocalDateTime.now());
		user1.addTicket(ticket1);

		USER_TICKET_DAO.saveUser(user1);

		// Insert user
		Client user2 = new Client();
		user2.setName("Francis");
		user2.setCreationDate(LocalDateTime.now());

		// add ticket
		Ticket ticket2 = new Ticket();
		ticket2.setTicketType(TicketType.MONTH);
		ticket2.setCreationDate(LocalDateTime.now());
		user2.addTicket(ticket2);

		USER_TICKET_DAO.saveUser(user2);

		// Insert user
		Client user3 = new Client();
		user3.setName("Francis");
		user3.setCreationDate(LocalDateTime.now());

		// add ticket
		Ticket ticket3 = new Ticket();
		ticket3.setTicketType(TicketType.MONTH);
		ticket3.setCreationDate(LocalDateTime.now());
		user3.addTicket(ticket3);

		USER_TICKET_DAO.saveUser(user3);


		// Retrieve Ticket from database
		Ticket ticketDB = USER_TICKET_DAO.findTicketById(1);
		log.info("From db: {}", ticketDB);

		// Retrieve tickets by userId
		List<Ticket> ticketsByUserId = USER_TICKET_DAO.findTicketsByUserId(1);

		// Retrieve user by id
		User userById = USER_TICKET_DAO.findUserById(1);

		// update TicketType
		USER_TICKET_DAO.updateTicketType(1, TicketType.YEAR);

		// delete user by id
		USER_TICKET_DAO.deleteUser(2);


	}
}

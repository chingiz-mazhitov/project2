package com.andersen;

import com.andersen.bus.TicketType;
import com.andersen.config.JpaConfig;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;
import com.andersen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class Main {


	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);

		UserService userService = ctx.getBean(UserService.class);

		// Insert user
		Client user1 = new Client();
		user1.setName("Ernest");
		user1.setCreationDate(LocalDateTime.now());

		// add ticket
		Ticket ticket1 = new Ticket();
		ticket1.setTicketType(TicketType.WEEK);
		ticket1.setCreationDate(LocalDateTime.now());
		user1.addTicket(ticket1);

		userService.saveUser(user1);

		user1.setName("Edward");
		userService.updateActivatedUser(user1);

//		 Insert user
		Client user2 = new Client();
		user2.setName("Francis");
		user2.setCreationDate(LocalDateTime.now());

		// add ticket
		Ticket ticket2 = new Ticket();
		ticket2.setTicketType(TicketType.MONTH);
		ticket2.setCreationDate(LocalDateTime.now());
		user2.addTicket(ticket2);

		userService.saveUser(user2);

		// Insert user
		Client user3 = new Client();
		user3.setName("Francis");
		user3.setCreationDate(LocalDateTime.now());

		// add ticket
		Ticket ticket3 = new Ticket();
		ticket3.setTicketType(TicketType.DAY);
		ticket3.setCreationDate(LocalDateTime.now());
		user3.addTicket(ticket3);

		userService.saveUser(user3);
		log.info("{}", user3);

		// Retrieve Ticket from database
		Ticket ticketDB = userService.findTicketById(1);
		log.info("From db: {}", ticketDB);

		// Retrieve tickets by userId
		List<Ticket> ticketsByUserId = userService.findTicketsByUserId(1);

		// Retrieve user by id
		User userById = userService.findUserById(1);

		// update TicketType
		userService.updateTicketType(1, TicketType.YEAR);

		// delete user by id
		userService.deleteUserById(2);

		User user = userService.findUserById(1);
		log.info("{}", user);

		User userWithTickets = userService.findUserWithTickets(1);
		log.info("{}", userWithTickets.getTickets());



	}
}

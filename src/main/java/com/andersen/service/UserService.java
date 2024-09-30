package com.andersen.service;

import com.andersen.bus.TicketType;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;

import java.util.List;

public interface UserService {

	void saveUser(User user);

	User findUserById(Integer id);

	User findUserWithTickets(Integer id);

	void deleteUserById(Integer id);


	void saveTicket(Ticket ticket);

	Ticket findTicketById(Integer id);

	List<Ticket> findTicketsByUserId(Integer id);

	void updateTicketType(Integer id, TicketType ticketType);

	void updateActivatedUser(Client client);

}

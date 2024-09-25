package com.andersen.dao;

import com.andersen.bus.TicketType;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;

import java.util.List;

public interface UserTicketDao {

	void saveTicket(Ticket ticket);

	void saveUser(User user);

	Ticket findTicketById(Integer id);

	List<Ticket> findTicketsByUserId(Integer id);

	User findUserById(Integer id);

	void updateTicketType(Integer id, TicketType ticketType);

	// deletes User cascading delete to tickets
	Client deleteUser(Integer id);

	// update user and its tickets
	void updateUserAndTickets(Client clientUpdate, List<Ticket> tickets);
}

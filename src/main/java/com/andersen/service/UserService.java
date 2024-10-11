package com.andersen.service;

import com.andersen.entity.User;

public interface UserService {

	void save(User user);

	User findById(Integer id);

	void delete(Integer id);

//	void saveUser(User user);
//
//	User findUserById(Integer id);
//
//	User findUserWithTickets(Integer id);
//
//	void deleteUserById(Integer id);
//
//
//	void saveTicket(Ticket ticket);
//
//	Ticket findTicketById(Integer id);
//
//	List<Ticket> findTicketsByUserId(Integer id);
//
//	void updateTicketType(Integer id, TicketType ticketType);
//
//	void updateActivatedUser(User client);

}

package com.andersen.dao;

import com.andersen.bus.TicketType;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;

import java.util.List;

public interface UserTicketDao extends CoreDao{

	Ticket saveTicket(Ticket ticket);

	User saveUser(User user);

	Ticket findTicketById(Integer id);

	List<Ticket> findTicketsByUserId(Integer id);

	User findUserById(Integer id);

	int updateTicketType(Ticket ticket);

	// deletes User cascading delete to tickets
	int deleteUser(Integer id);
}

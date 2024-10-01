package com.andersen.dao;

import com.andersen.bus.TicketType;
import com.andersen.entity.Ticket;

import java.util.List;

public interface TicketDao {

	void save(Ticket ticket);

	Ticket findById(Integer id);

	List<Ticket> findTicketsByUserId(Integer id);

	void updateTicketType(Integer id, TicketType ticketType);

}

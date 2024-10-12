package com.andersen.service;

import com.andersen.entity.Ticket;

public interface TicketService {

	void save(Ticket ticket);

	Ticket findById(Integer id);
}

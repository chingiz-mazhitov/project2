package com.andersen.service;

import com.andersen.entity.Ticket;

import java.util.List;

public interface TicketService {

	void save(Ticket ticket);

	Ticket findById(Integer id);

//	List<Ticket> findTicketByUserId(Integer id);
}

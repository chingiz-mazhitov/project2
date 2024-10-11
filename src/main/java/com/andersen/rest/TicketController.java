package com.andersen.rest;

import com.andersen.entity.Ticket;
import com.andersen.entity.User;
import com.andersen.service.TicketService;
import com.andersen.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class TicketController {

	private TicketService ticketService;

	@GetMapping("/tickets/{ticketId}")
	public Ticket findTicket(@PathVariable int ticketId) {
		Ticket ticket = ticketService.findById(ticketId);

		if(ticket == null) {
			log.error("Ticket id not found - " + ticketId);
			return null;
		}
		return ticket;
	}
}

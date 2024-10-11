package com.andersen.service;

import com.andersen.repo.TicketRepository;
import com.andersen.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
@AllArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService{

	private TicketRepository ticketRepository;

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Transactional(readOnly = true)
	@Override
	public Ticket findById(Integer id) {
		Optional<Ticket> result =  ticketRepository.findById(id);

		Ticket ticket = null;
		if (result.isPresent()) {
			ticket = result.get();
		} else {
			log.error("Did not find ticket id - {}", id);
		}
		return ticket;
	}

}

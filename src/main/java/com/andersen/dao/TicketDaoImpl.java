package com.andersen.dao;

import com.andersen.bus.TicketType;
import com.andersen.entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ticketDao")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TicketDaoImpl implements TicketDao{

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(Ticket ticket) {
		if (ticket == null) {
			em.persist(ticket);
		} else {
			em.merge(ticket);
		}
	}

	@Override
	public Ticket findById(Integer id) {
		return em.find(Ticket.class, id);
	}

	@Override
	public List<Ticket> findTicketsByUserId(Integer id) {

		TypedQuery<Ticket> query = em.createQuery(
				"from Ticket where client.id = :data", Ticket.class);
		query.setParameter("data", id);
		return query.getResultList();
	}

	@Override
	public void updateTicketType(Integer id, TicketType ticketType) {
		Ticket ticket = em.find(Ticket.class, id);
		log.info("TicketType before: {}", ticket.getTicketType());
		ticket.setTicketType(ticketType);

		ticket = em.merge(ticket);
		log.info("TicketType updated: " + ticket.getTicketType());
	}
}

package com.andersen.dao;

import com.andersen.bus.TicketType;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository("userDao")
@FieldDefaults(level = AccessLevel.PRIVATE)
@PropertySource("classpath:application.properties")
@Slf4j
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

	@Value("${ACTIVE}")
	String mode;

	@Override
	public void save(User user) {
		if (user == null) {
			em.persist(user);
		} else {
			em.merge(user);
		}
	}

	@Override
	public User findById(Integer id) {
		return em.find(Client.class, id);
	}

	@Override
	public User findWithTickets(Integer id) {
		return em.createNamedQuery(Client.FIND_WITH_TICKETS, Client.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public void delete(Integer id) {
		Client client = em.find(Client.class, id);
		em.remove(client);
		log.info("Deleted user: {}", client);
	}

	@Override
	public void updateActivatedUser(Client client) {
		if ("ON".equalsIgnoreCase(mode)) {

			Ticket ticket = new Ticket();
			ticket.setTicketType(TicketType.WEEK);
			ticket.setCreationDate(LocalDateTime.now());

			client.addTicket(ticket);
			client = em.merge(client);
			log.info("Update user: {}", client);
			log.info("Added ticket: {}", client.getTicket());
		} else {
			log.error("Client needs to be ACTIVATED");
		}
	}
}

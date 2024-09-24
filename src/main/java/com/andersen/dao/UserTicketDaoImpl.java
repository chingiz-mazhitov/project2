package com.andersen.dao;

import com.andersen.bus.TicketType;
import com.andersen.config.JDBCConfig;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

@Slf4j
public class UserTicketDaoImpl implements UserTicketDao {

	@Override
	public void saveTicket(Ticket ticket) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();

			log.info("Saving ticket {}", ticket);
			session.persist(ticket);
			session.getTransaction().commit();

			log.info("done");
			log.info("id: {}", ticket.getId());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void saveUser(User user) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();

			log.info("Saving user {}", user);
			session.persist(user);
			session.getTransaction().commit();

			log.info("done");
			log.info("id: {}", user.getId());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public Ticket findTicketById(Integer id) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();
			Ticket ticket = session.get(Ticket.class, id);
			log.info("Ticket with id: {} = {}", id, ticket);
			return ticket;

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Ticket> findTicketsByUserId(Integer id) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();
			Query<Ticket> query = session.createQuery("from Ticket where client.id = :data", Ticket.class);
			query.setParameter("data", id);

			// execute query
			List<Ticket> tickets = query.getResultList();
			session.getTransaction().commit();

			log.info("list size = {}", tickets.size());
			return tickets;

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return Collections.emptyList();
	}

	@Override
	public User findUserById(Integer id) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();
			Client client = session.get(Client.class, id);
			session.getTransaction().commit();
			log.info("Client with id: {} = {}",id,  client);
			return client;

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateTicketType(Integer id, TicketType ticketType) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();
			Ticket ticket = session.get(Ticket.class, id);
			log.info("Ticket before updating: {}",ticket);

			ticket.setTicketType(ticketType);
			session.getTransaction().commit();;
			log.info("Ticket with id: {} = {} after updating", id, ticket);

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public Client deleteUser(Integer id) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();
			Client client = session.get(Client.class, id);
			log.info("Client before deleting: {}", client);
			session.remove(client);
			session.getTransaction().commit();
			return client;

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateUserAndTickets(Client clientUpdate, List<Ticket> tickets) {
		try (Session session = JDBCConfig.getSession()) {

			session.beginTransaction();
			if (clientUpdate.getId() != null) {
				Client client = session.get(Client.class, clientUpdate.getId());
				log.info("Client before updating: {}", client);
			}

			for (Ticket ticket : tickets) {
				clientUpdate.addTicket(ticket);
			}
			session.merge(clientUpdate);
			session.getTransaction().commit();

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}

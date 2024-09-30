package com.andersen.dao;

import com.andersen.entity.Client;
import com.andersen.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

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
}

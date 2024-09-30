package com.andersen.service;

import com.andersen.bus.TicketType;
import com.andersen.dao.TicketDao;
import com.andersen.dao.UserDao;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("userService")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

	UserDao userDao;
	TicketDao ticketDao;

	@Autowired
	public UserServiceImpl(UserDao userDao, TicketDao ticketDao) {
		this.userDao = userDao;
		this.ticketDao = ticketDao;
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User findUserById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public User findUserWithTickets(Integer id) {
		return userDao.findWithTickets(id);
	}

	@Override
	public void deleteUserById(Integer id) {
		userDao.delete(id);
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketDao.save(ticket);
	}

	@Transactional(readOnly = true)
	@Override
	public Ticket findTicketById(Integer id) {
		return ticketDao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ticket> findTicketsByUserId(Integer id) {
		return ticketDao.findTicketsByUserId(id);
	}

	@Override
	public void updateTicketType(Integer id, TicketType ticketType) {
		ticketDao.updateTicketType(id, ticketType);
	}

	@Override
	public void updateActivatedUser(Client client) {
		userDao.updateActivatedUser(client);
	}
}

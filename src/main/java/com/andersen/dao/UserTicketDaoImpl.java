package com.andersen.dao;

import com.andersen.bus.TicketType;
import com.andersen.entity.Client;
import com.andersen.entity.Ticket;
import com.andersen.entity.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserTicketDaoImpl implements UserTicketDao {

	@Override
	public Ticket saveTicket(Ticket ticket) {

		String insertTicket = """
				INSERT INTO my_ticket_service_db.Ticket (user_id, ticket_type, creation_date) values (?, ?, ?)""";
		try (Connection conn = getConnection();
			 PreparedStatement statement =
					 conn.prepareStatement(insertTicket, Statement.RETURN_GENERATED_KEYS)) {
			statement.setInt(1, ticket.getUser().getId());
			statement.setString(2, ticket.getTicketType().name());
			statement.setTimestamp(3, Timestamp.valueOf(ticket.getCreationDate()));
			statement.execute();
			ResultSet rs = statement.getGeneratedKeys();
			Integer ticketId = (rs != null && rs.next()) ? rs.getInt(1) : null;
			ticket.setId(ticketId);

			return ticket;
		} catch (SQLException e) {
			System.err.println("Problem executing Ticket INSERT" + e);
		}
		return null;
	}

	@Override
	public User saveUser(User user) {

		String insertTicket = """
				INSERT INTO my_ticket_service_db.User (name, creation_date) values (?, ?)""";
		try (Connection conn = getConnection();
			 PreparedStatement statement =
					 conn.prepareStatement(insertTicket, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, user.getName());
			statement.setTimestamp(2, Timestamp.valueOf(user.getCreationDate()));
			statement.execute();
			ResultSet rs = statement.getGeneratedKeys();
			Integer userId = (rs != null && rs.next()) ? rs.getInt(1) : null;
			user.setId(userId);

			return user;
		} catch (SQLException e) {
			System.err.println("Problem executing User INSERT" + e);
		}
		return null;
	}

	@Override
	public Ticket findTicketById(Integer id) {
		String query = """
				SELECT * FROM my_ticket_service_db.Ticket WHERE id=?""";
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			Integer ticketId;
			Integer userId;
			TicketType ticketType;
			Timestamp timestamp;
			LocalDateTime creationDate;

			Ticket ticket = null;

			while (rs.next()) {
				ticketId = rs.getInt("id");
				userId = rs.getInt("user_id");
				ticketType = TicketType.valueOf(rs.getString("ticket_type"));
				timestamp = rs.getTimestamp("creation_date");
				creationDate = timestamp.toLocalDateTime();


				ticket = new Ticket();
				ticket.setId(ticketId);
				ticket.setTicketType(ticketType);
				ticket.setCreationDate(creationDate);
			}

			return ticket;
		} catch (SQLException e) {
			System.err.println("Problem while executing Ticket SELECT" + e);
		}

		return null;
	}

	@Override
	public List<Ticket> findTicketsByUserId(Integer id) {

		String query = """
				SELECT * FROM my_ticket_service_db.Ticket 
				WHERE user_id = ?""";

		List<Ticket> tickets = new ArrayList<>();

		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			Integer ticketId;
			TicketType ticketType;
			Timestamp timestamp;
			LocalDateTime creationDate;
			Ticket ticket =null;
			while (rs.next()) {
				ticketId = rs.getInt("id");
				ticketType = TicketType.valueOf(rs.getString("ticket_type"));
				timestamp = rs.getTimestamp("creation_date");
				creationDate = timestamp.toLocalDateTime();
				ticket = new Ticket();

				ticket.setId(ticketId);
				ticket.setTicketType(ticketType);
				ticket.setCreationDate(creationDate);

				tickets.add(ticket);
			}

			return tickets;
		} catch (SQLException e) {
			System.err.println("Problem while executing Tickets SELECT " + e);
		}
		return null;
	}

	@Override
	public User findUserById(Integer id) {
		String query = """
				SELECT * FROM my_ticket_service_db.User WHERE id=?""";
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			Integer userId;
			String name;
			Timestamp timestamp;
			LocalDateTime creationDate;

			User user = null;

			while (rs.next()) {
				userId = rs.getInt("id");
				name = rs.getString("name");
				timestamp = rs.getTimestamp("creation_date");
				creationDate = timestamp.toLocalDateTime();


				user = new Client();
				user.setId(userId);
				user.setName(name);
				user.setCreationDate(creationDate);
			}

			return user;
		} catch (SQLException e) {
			System.err.println("Problem while executing User SELECT" + e);
		}

		return null;
	}

	@Override
	public int updateTicketType(Ticket ticket) {

		String ticketType = ticket.getTicketType().name();
		String query = """
				UPDATE Ticket SET ticket_type = ? WHERE id = ?""";
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(query)) {

			statement.setString(1, ticketType);
			statement.setInt(2, ticket.getId());

			return statement.executeUpdate();


		} catch (SQLException e) {
			System.err.println("Problem while executing Ticket UPDATE" + e);
		}

		return -1;
	}

	@Override
	public int deleteUser(Integer id) {
		String query = """
				DELETE FROM User WHERE id = ?""";

		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, id);
			return statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Problem while executing User DELETE " + e);
		}

		return -1;
	}
}

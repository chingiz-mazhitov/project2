package com.andersen.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CoreDao {

	default Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/my_ticket_service_db",
				"********", "*******");
	}

	default void closeConnection(Connection connection) throws SQLException {
		if (connection == null) {
			return;
		}
		connection.close();
	}
}

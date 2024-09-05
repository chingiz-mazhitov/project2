package com.andersen.users;

import com.andersen.Identify;
import com.andersen.Ticket;

public abstract class User extends Identify {

	protected Ticket ticket;

	public User(Ticket ticket) {
		this.ticket = ticket;
	}

	public abstract void printRole();
}

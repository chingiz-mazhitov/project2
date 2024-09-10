package com.andersen;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BusTicket {

	private TicketClass ticketClass;

	private TicketType ticketType;

	private LocalDate dt;

	private BigDecimal price;

	public BusTicket(TicketClass ticketClass, TicketType ticketType, LocalDate dt, BigDecimal price) {

		this.ticketClass = ticketClass;
		this.ticketType = ticketType;
		this.dt = dt;
		this.price = price;
	}

	@Override
	public String toString() {
		return "BusTicket{" +
				"ticketClass=" + ticketClass +
				", ticketType=" + ticketType +
				", dt=" + dt +
				", price=" + price +
				'}';
	}

	enum TicketClass {
		CLA,
		STD
	}

	enum TicketType {
		DAY,
		WEEK,
		YEAR
	}
}

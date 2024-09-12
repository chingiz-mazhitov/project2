package com.andersen.bus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BusTicket {

	private TicketClass ticketClass;

	private TicketType ticketType;

	private LocalDate startDate;

	private BigDecimal price;

	public BusTicket() {
	}

	public BusTicket(TicketClass ticketClass, TicketType ticketType, LocalDate startDate, BigDecimal price) {

		this.ticketClass = ticketClass;
		this.ticketType = ticketType;
		this.startDate = startDate;
		this.price = price;
	}

	public TicketClass getTicketClass() {
		return ticketClass;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "BusTicket{" +
				"ticketClass=" + ticketClass +
				", ticketType=" + ticketType +
				", dt=" + startDate +
				", price=" + price +
				'}';
	}
}

package com.andersen.bus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class BusTicketService {
	public static void main(String[] args) {

		LocalDate dt = LocalDate.now();
		BigDecimal price = BigDecimal.valueOf(10);
		BusTicket ticket = new BusTicket(BusTicket.TicketClass.STD, TicketType.WEEK, dt, price);

		System.out.println(ticket.getTicketType());
		System.out.println(ticket.getStartDate().get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
//		System.out.println(ticket);

//		if (price.compareTo(BigDecimal.ZERO) > 0) {
//			System.out.println("true");
//		}

//		System.out.println(price.compareTo(BigDecimal.ZERO));
	}
}

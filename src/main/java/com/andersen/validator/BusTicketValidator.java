package com.andersen.validator;

import com.andersen.bus.BusTicket;
import com.andersen.bus.TicketType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

public class BusTicketValidator {

	public List<BusTicket> isValid(List<BusTicket> list) {

		List<BusTicket> validatedList = new ArrayList<>();
		int total = list.size();

		int ticketTypeViolation = 0;
		int startDateViolation = 0;
		int priceViolation = 0;
		String violationName;
		for (BusTicket busTicket : list) {

			// retrieve values
			TicketType ticketType = busTicket.getTicketType();
			LocalDate startDate = busTicket.getStartDate();
			BigDecimal price = busTicket.getPrice();

			// do validation
			if (!ticketTypeValidate(ticketType)) {
				System.err.println("Invalid Ticket Type: " + ticketType);
				ticketTypeViolation++;
			} else if (!startDateValidate(startDate, ticketType)) {
				System.err.println("Invalid start date: " + startDate);
				startDateViolation++;
			} else if (!priceValidate(price)) {
				System.err.println("Invalid price: " + price);
				priceViolation++;
			} else {
				validatedList.add(busTicket);
			}
		}

		int commonViolation = Math.max(ticketTypeViolation, Math.max(startDateViolation, priceViolation));
		System.out.println("Total = " + total);
		System.out.println("Valid tickets = " + validatedList.size());

		violationName = (commonViolation == ticketTypeViolation) ? "ticketTypeViolation" :
						(commonViolation == startDateViolation) ? "startDateViolation" : "priceViolation";
		System.out.println("Popular violations = " + violationName);

		return validatedList;
	}

	public boolean startDateValidate(LocalDate dt, TicketType ticketType) {
		boolean result;
		LocalDate now = LocalDate.now();
		int currentDayOfYear = now.getDayOfYear();
		int currentWeekOfYear = now.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		int currentYear = now.getYear();

		// start date validation happens here
		if (dt == null || dt.isAfter(now)) {
			result = false;
		} else {
			switch (ticketType) {
				case DAY -> result = dt.getDayOfYear() <= currentDayOfYear;

				case WEEK -> result = dt.get(ChronoField.ALIGNED_WEEK_OF_YEAR) <= currentWeekOfYear;

				case YEAR -> result = dt.getYear() <= currentYear;

				default -> result = false;
			}
		}

		return result;
	}

	public boolean priceValidate(BigDecimal price) {
		boolean result;
		BigDecimal remainder = price.remainder(BigDecimal.TWO);

		if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
			result = false;
		} else if (remainder.compareTo(BigDecimal.ZERO) > 0) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	public boolean ticketTypeValidate(TicketType ticketType) {
		return (ticketType != TicketType.PRIME && ticketType != null);
	}

}

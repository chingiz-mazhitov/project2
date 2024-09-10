package com.andersen.validator;

import com.andersen.bus.TicketType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface CustomConstraintValidator<T> {

	void isValid(List<T> item);
	boolean startDateValidate(LocalDate dt, TicketType ticketType);
	boolean priceValidate(BigDecimal price);
	boolean ticketTypeValidate(TicketType ticketType);
}

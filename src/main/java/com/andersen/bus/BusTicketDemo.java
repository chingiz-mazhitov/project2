package com.andersen.bus;

import com.andersen.validator.BusTicketValidator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusTicketDemo {
	public static void main(String[] args) {

		Path path = Path.of("src/main/java/com/andersen/bus/info.json");

		List<BusTicket> validTickets = CustomJsonReader.getValidBusTickets(path);

		System.out.println("-".repeat(80));
		for (BusTicket validTicket : validTickets) {
			System.out.println(validTicket);
		}

	}
}

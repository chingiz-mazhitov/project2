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

		List<BusTicket> validTickets = readJSONFile(path);

		System.out.println("-".repeat(80));
		for (BusTicket validTicket : validTickets) {
			System.out.println(validTicket);
		}


	}

	public static List<BusTicket> readJSONFile(Path path) {
		try {
			String content = new String(Files.readAllBytes(path));
			JSONObject jsonObject = new JSONObject(content);
			JSONArray jsonArray = jsonObject.getJSONArray("tickets");

			BusTicketValidator validator = new BusTicketValidator();
			List<BusTicket> ticketsToPass = new ArrayList<>();
			BusTicket busTicket;

			for (int i = 0; i < jsonArray.length(); i++) {
				var element = jsonArray.getJSONObject(i);
				String ticketClass = element.optString("ticketClass", null);
				String ticketType = element.optString("ticketType", null);
				String startDate = element.optString("startDate", null);
				BigDecimal price = element.optBigDecimal("price", null);

				TicketClass ticketClassConverted = (ticketClass != null) ? TicketClass.valueOf(ticketClass) : null;
				TicketType ticketTypeConverted = (ticketType != null) ? TicketType.valueOf(ticketType) : null;
				LocalDate startDateConverted = (startDate == null || startDate.isEmpty()) ? null : LocalDate.parse(startDate);

				busTicket = new BusTicket(ticketClassConverted, ticketTypeConverted, startDateConverted, price);
				ticketsToPass.add(busTicket);
			}

			return validator.isValid(ticketsToPass);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

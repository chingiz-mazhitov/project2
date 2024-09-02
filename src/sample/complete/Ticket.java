package sample.complete;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class Ticket {

	private static int DEFAULT_ID = 0;
	private static final double DEFAULT_BAGGAGE_LIMIT = 10.200;
	private static final long DEFAULT_TIME = System.currentTimeMillis() / 1000;
	private static final int DISCOUNT = 2;

	private int id;
	private String concertHall;
	private int code;
	private long time; //System.currentTimeMillis() / 1000;
	private boolean isPromo;
	private char sector;
	private double baggageLimit;
	public BigDecimal price = BigDecimal.valueOf(20.50);


	public Ticket() {
		this(++DEFAULT_ID, "Hall", 0,DEFAULT_TIME,
				true, 'A', DEFAULT_BAGGAGE_LIMIT);
	}

	public Ticket(int id, String concertHall, int code, long time, boolean isPromo, char sector, double baggageLimit) {

		this.id = (id >= 0 && id <= 9999) ? id : ++DEFAULT_ID;
		this.baggageLimit = baggageLimit;
		this.code = (code >= 0 && code <= 999) ? code : 0;

		if (concertHall.length() < 10) {
			this.concertHall = concertHall;
		} else {
			this.concertHall = concertHall.substring(0, 10);
		}

		this.isPromo = isPromo;
		this.sector = sector;
		this.time = time;
		this.price = isPromo ? (price.subtract(BigDecimal.valueOf(DISCOUNT))) : price;

	}

	public Ticket(String concertHall, int code, long time) {
		this(++DEFAULT_ID, concertHall, code, time, true, 'A', DEFAULT_BAGGAGE_LIMIT);
	}

	public int getId() {
		return id;
	}
// need for getTicketsByStadiumSector function
	public char getSector() {
		return sector;
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"baggageLimit=" + baggageLimit +
				", id=" + id +
				", concertHall='" + concertHall + '\'' +
				", event code=" + String.format("%03d", code) +
				", time=" + time +
				", isPromo=" + isPromo +
				", sector=" + sector +
				", price=" + price +
				'}';
	}
}

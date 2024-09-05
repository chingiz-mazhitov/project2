package sample.complete;

import java.math.BigDecimal;

public class Ticket implements Identifiable{

	private static final int DISCOUNT = 2;

	private int id;
	private String concertHall;
	private int eventCode;
	private long timeStamp;
	private boolean isPromo;
	private char sector;
	private double baggageLimit;
	private BigDecimal price = BigDecimal.valueOf(20.50);

	public Ticket() {

	}

	public Ticket(String concertHall, int eventCode, long timeStamp) {
		this.concertHall = concertHall;
		this.eventCode = eventCode;
		this.timeStamp = timeStamp;
	}

	public Ticket(int id, String concertHall, int eventCode, long timeStamp, boolean isPromo, char sector, double baggageLimit) {
		this.id = (id > 0 && id <= 9999) ? id : ++id;
		if (concertHall.length() < 10) {
			this.concertHall = concertHall;
		} else {
			this.concertHall = concertHall.substring(0, 10);
		}
		this.eventCode = (eventCode >= 100 && eventCode <= 999) ? eventCode : 100;
		this.timeStamp = timeStamp;
		this.isPromo = isPromo;
		this.sector = sector;
		this.baggageLimit = baggageLimit;
		this.price = isPromo ? (price.subtract(BigDecimal.valueOf(DISCOUNT))) : price;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {

	}

	public char getSector() {
		return this.sector;
	}

	public void setSector(char sector) {
		this.sector = sector;
	}

	public String getConcertHall() {
		return concertHall;
	}

	public int getEventCode() {
		return eventCode;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isPromo() {
		return isPromo;
	}

	public double getBaggageLimit() {
		return baggageLimit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	// define overloaded share() methods since static polymorphism is chosen
	public void share(String phoneNumber) {
		System.out.println("Sharing ticket via phone");
		System.out.println("Sharing ticket via email to " + phoneNumber + " " + this);
	}

	public void share(String phoneNumber, String email) {
		System.out.println("Sharing ticket via phone and email");
		System.out.printf("phone: %s, email: %s ticket details: %s\n", phoneNumber, email, this);
	}

	@Override
	public void print() {
		System.out.printf("""
				Ticket details
				Id: %d
				Concert Hall: %s
				Event Code: %d
				Time: %d
				isPromo: %b
				Sector: %c
				Baggage Limit: %f
				Price: %f""", id, concertHall, eventCode, timeStamp, isPromo, sector, baggageLimit, price);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Ticket ticket = (Ticket) o;
		return id == ticket.id && timeStamp == ticket.timeStamp;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + Long.hashCode(timeStamp);
		return result;
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", concertHall='" + concertHall + '\'' +
				", eventCode=" + eventCode +
				", timeStamp=" + timeStamp +
				", isPromo=" + isPromo +
				", sector=" + sector +
				", baggageLimit=" + baggageLimit +
				", price=" + price +
				'}';
	}

}

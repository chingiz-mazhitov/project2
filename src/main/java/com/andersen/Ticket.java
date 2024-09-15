package com.andersen;

import com.andersen.validator.CheckNullFields;
import com.andersen.validator.NullableWarning;

import java.math.BigDecimal;

public class Ticket extends Identify {

	private static final int DISCOUNT = 2;

	@NullableWarning
	private String concertHall;

	private int eventCode;

	private long timeStamp;

	private boolean isPromo;

	@NullableWarning
	private char sector;

	private double baggageLimit;

	@NullableWarning
	private BigDecimal price = BigDecimal.valueOf(20.50);

	public Ticket() {
		CheckNullFields.checkNullFields(this);
	}

	public Ticket(String concertHall, int eventCode, long timeStamp) {

		CheckNullFields.checkNullFields(this);
		this.concertHall = concertHall;
		this.eventCode = eventCode;
		this.timeStamp = timeStamp;
	}

	public Ticket(int id, String concertHall, int eventCode, long timeStamp, boolean isPromo, char sector, double baggageLimit) {

		CheckNullFields.checkNullFields(this);
		super.id = (id > 0 && id <= 9999) ? id : ++id;
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

	public char getSector() {
		return this.sector;
	}

	public void setSector(char sector) {
		this.sector = sector;
	}

	public String getConcertHall() {
		return this.concertHall;
	}

	public int getEventCode() {
		return this.eventCode;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isPromo() {
		return this.isPromo;
	}

	public double getBaggageLimit() {
		return this.baggageLimit;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	// define overloaded share() methods since static polymorphism is chosen
	public void share(String phoneNumber) {
		System.out.println("Sharing ticket via phone");
		System.out.printf("phone: %s, ticket details: %s\n", phoneNumber, this);
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

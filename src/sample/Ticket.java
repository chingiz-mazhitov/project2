package sample;

import java.util.Arrays;
import java.util.Random;

public class Ticket {

	private static final int DEFAULT_ID = 1;
	private int id;
	private int defaultID = 0;
	private String concertHall;
	private int code;
	private long time; //System.currentTimeMillis() / 1000;
	private boolean isPromo;
	private char sector;
	private double baggageLimit;
	private char[] charArray = "ABCDEFGHIJ".toCharArray();
	private Random random = new Random();
	private int index;

	public Ticket(int id, String concertHall, int code, long time, boolean isPromo, char sector, double baggageLimit) {
		this.id = (id >= 0 && id <= 9999) ? id : 0;
		this.baggageLimit = baggageLimit;
		this.code = (code >= 0 && code <= 999) ? code : 0;
//		String checkCode = String.format("%03d", this.code);
//		System.out.println(checkCode);
		this.concertHall = concertHall.substring(0, 10);
		this.isPromo = isPromo;
		this.sector = sector;
		this.time = time;
	}

	public Ticket(String concertHall, int code, long time) {
		this(DEFAULT_ID, concertHall, code, time, true, 'A', 10.00);
//		this.concertHall = concertHall;
//		this.code = code;
//		this.time = time;
//		this.id = 1;
//		this.isPromo = new Random().nextBoolean();
//		this.index = random.nextInt(0, charArray.length);
//		this.sector = charArray[index];
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"baggageLimit=" + baggageLimit +
				", id=" + id +
				", concertHall='" + concertHall + '\'' +
				", code=" + code +
				", event code=" + String.format("%03d", code) +
				", time=" + time +
				", isPromo=" + isPromo +
				", sector=" + sector +
				", charArray=" + Arrays.toString(charArray) +
				", random=" + random +
				", index=" + index +
				'}';
	}
}

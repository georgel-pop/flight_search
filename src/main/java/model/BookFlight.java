package model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookFlight {

	private Flight flight;
	private Date date;

	public BookFlight(Flight flight, Date date) {
		this.flight = flight;
		this.date = date;
	}

	public Flight getFlight() {
		return flight;
	}

	public Date getDate() {
		return date;
	}

	public double getDaysDisc() {
		double discount = 1.5;
		Date now = new Date();
		long diff = date.getTime() - now.getTime();
		long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		if (days > 30) {
			discount = 0.8;
		} else if (days <= 30 && days >= 16) {
			discount = 1;
		} else if (days <= 15 && days >= 3) {
			discount = 1.2;
		}
		return discount;
	}
}

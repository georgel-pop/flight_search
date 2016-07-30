package model;

import java.util.Date;

public class Flight {
	private Airport origin;
	private Airport destination;
	private String flightNr;
	private double price;
	private Airline airline;

	public Airline getAirline() {
		return airline;
	}

	public Airport getOrigin() {
		return origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public String getFlightNr() {
		return flightNr;
	}

	public double getPrice() {
		return price;
	}

	public Flight(String origin, String destination, String flightNr, double price) {
		this.origin = setAirport(origin);
		this.destination = setAirport(destination);
		this.flightNr = flightNr;
		this.price = price;
		setAirline(flightNr);
	}

	private Airport setAirport(String airportCode) {
		for (Airport a : Airport.values()) {
			if (a.getCode().equals(airportCode)) {
				return a;
			}
		}
		return null;
	}

	private void setAirline(String flightNr) {
		String airlineCode = flightNr.substring(0, 2);
		for (Airline a : Airline.values()) {
			if (a.getCode().equals(airlineCode)) {
				this.airline = a;
				break;
			}
		}
	}

	public double getTotalPrice(Date date, int nrAdult, int nrChild, int nrInfant) {
		BookFlight bookFlight = new BookFlight(this, date);
		Passager a = new Adult(bookFlight, nrAdult);
		Passager c = new Child(bookFlight, nrChild);
		Passager i = new Infant(bookFlight, nrInfant);
		return a.getPrice() + c.getPrice() + i.getPrice();
	}
}

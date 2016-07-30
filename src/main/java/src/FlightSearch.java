package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Airport;
import model.Flight;

public class FlightSearch {
	Airport origin;
	Airport destination;
	Date date;
	List<Flight> flightsData;

	public FlightSearch(List<Flight> flightsData, Airport origin, Airport destination, Date date) {
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.flightsData = flightsData;
	}

	public void printFlightPrices(int nrAdult) {
		printFlightPrices(nrAdult, 0, 0);
	}

	public void printFlightPrices(int nrAdult, int nrChild) {
		printFlightPrices(nrAdult, nrChild, 0);
	}

	public void printFlightPrices(int nrAdult, int nrChild, int nrInfant) {
		List<Flight> flights = searchFlights();
		if (flights.isEmpty()) {
			System.out.println("No flights available!");
		}
		for (Flight f : flights) {
			System.out.println(f.getFlightNr() + ", " + f.getTotalPrice(this.date, nrAdult, nrChild, nrInfant) + " E");
		}

	}

	public List<Flight> searchFlights() {
		List<Flight> flights = new ArrayList<>();
		for (Flight f : flightsData) {
			if (f.getOrigin().equals(origin) && f.getDestination().equals(destination)) {
				flights.add(f);
			}
		}
		return flights;
	}

}

package test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Airline;
import model.Airport;
import model.BookFlight;
import model.Flight;
import src.FlightSearch;
import src.LoadData;

public class AppTest {

	static LoadData data;

	@BeforeClass
	public static void initialize() {
		data = new LoadData("src\\test\\resources\\flights.csv");
	}

	@Test
	public void testLoadData() {
		assertEquals(89, data.getFlights().size());
	}

	@Test
	public void testAirportName() {
		assertEquals("Madrid", Airport.Madrid.getName());
	}

	@Test
	public void testAirlineName() {
		assertEquals("British Airways", Airline.British_Airways.getName());
	}

	@Test
	public void testDaysToDepartueDiscount() {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		BookFlight bookFlight = new BookFlight(null, c.getTime());
		// < 3
		c.add(Calendar.DATE, 2); // number of days to add
		bookFlight = new BookFlight(null, c.getTime());
		assertEquals(1.5, bookFlight.getDaysDisc(), 0.01);
		// >= 3 : <=15
		c.add(Calendar.DATE, 13); // number of days to add
		bookFlight = new BookFlight(null, c.getTime());
		assertEquals(1.2, bookFlight.getDaysDisc(), 0.01);
		// >= 16 : <=30
		c.add(Calendar.DATE, 15); // number of days to add
		bookFlight = new BookFlight(null, c.getTime());
		assertEquals(1.0, bookFlight.getDaysDisc(), 0.01);
		// >30
		c.add(Calendar.DATE, 2); // number of days to add
		bookFlight = new BookFlight(null, c.getTime());
		assertEquals(0.8, bookFlight.getDaysDisc(), 0.01);
	}

	@Test
	public void testFligthSearch() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 31);
		FlightSearch search = new FlightSearch(data.getFlights(), Airport.Amsterdam, Airport.Frakfurt, c.getTime());
		List<Flight> found = search.searchFlights();
		assertEquals(3, found.size());
		// TK2372
		// TK2659
		// LH5909
		assertEquals("TK2372", found.get(0).getFlightNr());
		assertEquals("TK2659", found.get(1).getFlightNr());
		assertEquals("LH5909", found.get(2).getFlightNr());

		// search for no existent flight route
		FlightSearch search_2 = new FlightSearch(data.getFlights(), Airport.Paris, Airport.Frakfurt, c.getTime());
		List<Flight> found_2 = search_2.searchFlights();
		assertEquals(true, found_2.isEmpty());
	}

	@Test
	public void testFlightPrice() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 32);
		FlightSearch search = new FlightSearch(data.getFlights(), Airport.Amsterdam, Airport.Frakfurt, c.getTime());
		List<Flight> found = search.searchFlights();
		assertEquals(3, found.size());
		// TK2372
		// TK2659
		// LH5909
		assertEquals(157.6, found.get(0).getTotalPrice(c.getTime(), 1, 0, 0), 0.01);
		assertEquals(198.4, found.get(1).getTotalPrice(c.getTime(), 1, 0, 0), 0.01);
		assertEquals(90.4, found.get(2).getTotalPrice(c.getTime(), 1, 0, 0), 0.01);
	}

	@Test
	public void testPrintFlights() {
		System.out.println("1 adult, 30 days to the departure date, flying AMS -> FRA");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 31);
		FlightSearch search = new FlightSearch(data.getFlights(), Airport.Amsterdam, Airport.Frakfurt, c.getTime());
		search.printFlightPrices(1);

		System.out.println("2 adults, 1 child, 1 infant, 15 days to the departure date, flying LHR -> IST");
		Calendar c0 = Calendar.getInstance();
		c0.setTime(new Date());
		c0.add(Calendar.DATE, 15);
		FlightSearch search0 = new FlightSearch(data.getFlights(), Airport.London, Airport.Istanbul, c0.getTime());
		search0.printFlightPrices(2, 1, 1);

		System.out.println("1 adult, 2 children, 2 days to the departure date, flying BCN -> MAD");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		c1.add(Calendar.DATE, 2);
		FlightSearch search1 = new FlightSearch(data.getFlights(), Airport.Barcelona, Airport.Madrid, c1.getTime());
		search1.printFlightPrices(1, 2);

		System.out.println("1 adult, 2 children, 2 days to the departure date, flying CDG -> FRA");
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date());
		c2.add(Calendar.DATE, 2);
		FlightSearch search2 = new FlightSearch(data.getFlights(), Airport.Paris, Airport.Frakfurt, c2.getTime());
		search2.printFlightPrices(1, 2);

	}
}

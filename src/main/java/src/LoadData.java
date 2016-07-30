package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Flight;

public class LoadData {
	private String csvFile = null;
	private List<Flight> flights = new ArrayList<>();

	public LoadData(String csvFile) {
		this.csvFile = csvFile;
		loadData();
	}

	private void loadData() {
		String line = "";
		String cvsSplitBy = ",";
		System.out.println("Load flights data....");
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] flight = line.split(cvsSplitBy);
				String origin = flight[0];
				String destination = flight[1];
				String flightNr = flight[2];
				double price = Double.parseDouble(flight[3]);
				flights.add(new Flight(origin, destination, flightNr, price));
				System.out.println(origin + "," + destination + "," + flightNr + "," + price);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Flight> getFlights() {
		return flights;
	}

}

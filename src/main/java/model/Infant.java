package model;

public class Infant extends Passager {

	public Infant(BookFlight bookFlight, int total) {
		super(bookFlight, total);
	}

	@Override
	public double getPrice() {
		return getTotal() * (getBookFlight().getFlight().getAirline().getInfantPrice());
	}

}

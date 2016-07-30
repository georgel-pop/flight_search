package model;

public class Child extends Adult {

	public Child(BookFlight bookFlight, int total) {
		super(bookFlight, total);
	}

	@Override
	public double getPrice() {
		return super.getPrice() * 0.67;
	}

}

package model;

/**
 * 
 */

/**
 * @author gpop
 *
 */
public abstract class Passager {
	private int total;
	private BookFlight bookFlight;

	public int getTotal() {
		return total;
	}

	public BookFlight getBookFlight() {
		return bookFlight;
	}

	public Passager(BookFlight bookFlight, int total) {
		this.bookFlight = bookFlight;
		this.total = total;
	}

	abstract public double getPrice(); // in euro
}

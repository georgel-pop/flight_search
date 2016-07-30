package model;

/**
 * 
 */

/**
 * @author gpop
 *
 */
public class Adult extends Passager {

	public Adult(BookFlight bookFlight, int total) {
		super(bookFlight, total);
	}

	@Override
	public double getPrice() {
		double price = getBookFlight().getFlight().getPrice();
		double daysDisc = getBookFlight().getDaysDisc();
		return (price * daysDisc) * getTotal();
	}
}

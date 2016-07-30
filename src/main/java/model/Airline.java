package model;
/**
 * 
 */


/**
 * @author gpop
 *
 */
public enum Airline {
	Iberia("IB", "Iberia", 10), 
	British_Airways("BA", "British Airways", 15), 
	Lufthansa("LH", "Lufthansa", 7), 
	Ryanair("FR", "Ryanair", 20), 
	Vueling("VY", "Vueling", 10), 
	Turkish_Airlines("TK", "Turkish Airlines", 5), 
	Easyjet("U2", "Easyjet", 19.90);

	private final String code;
	private final String name;
	private final double infantPrice; // in Euro

	Airline(String code, String name, double infantPrice) {
		this.code = code;
		this.name = name;
		this.infantPrice = infantPrice;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getInfantPrice() {
		return infantPrice;
	}

}

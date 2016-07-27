/**
 * 
 */


/**
 * @author gpop
 *
 */
public enum Airline {
	IB("IB", "Iberia", 10), 
	BA("BA", "British Airways", 15), 
	LH("LH", "Lufthansa", 7), 
	FR("FR", "Ryanair", 20), 
	VY("VY", "Vueling", 10), 
	TK("TK", "Turkish Airlines", 5), 
	U2("U2", "Easyjet", 19.90);

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

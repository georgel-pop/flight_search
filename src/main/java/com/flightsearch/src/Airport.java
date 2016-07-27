package com.flightsearch.src;
/**
 * 
 */


/**
 * @author gpop
 *
 */
public enum Airport {
	Madrid("MAD", "Madrid"), 
	Barcelona("BCN", "Barcelona"), 
	London("LHR", "London"), 
	Paris("CDG","Paris"), 
	Frakfurt("FRA", "Frakfurt"), 
	Istanbul("IST", "Istanbul"),
	Amsterdam("AMS", "Amsterdam"), 
	Rome("FCO", "Rome"), 
	Copenhagen("CPH", "Copenhagen");

	private final String code;
	private final String name;

	Airport(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}

package com.flightApplication.demo.model;

import java.math.BigDecimal;

public class RouteInput {

	private String airportIdFrom;
	private String airportIdTo;
	private String flightcompanyId;
	private BigDecimal defaultPrice;

	public String getAirportIdFrom() {
		return airportIdFrom;
	}

	public void setAirportIdFrom(String airportIdFrom) {
		this.airportIdFrom = airportIdFrom;
	}

	public String getAirportIdTo() {
		return airportIdTo;
	}

	public void setAirportIdTo(String airportIdTo) {
		this.airportIdTo = airportIdTo;
	}

	public String getFlightcompanyId() {
		return flightcompanyId;
	}

	public void setFlightcompanyId(String flightcompanyId) {
		this.flightcompanyId = flightcompanyId;
	}

	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

}

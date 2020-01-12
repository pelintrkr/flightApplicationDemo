package com.flightApplication.demo.model;

public enum TicketStatusEnum {

	ACTIVE("1"), CANCELLED("0");

	private final String statusValue;

	TicketStatusEnum(final String newValue) {
		statusValue = newValue;
	}

	public String getValue() {
		return statusValue;
	}

}

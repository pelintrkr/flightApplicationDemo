package com.flightApplication.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FlightCompany")
public class FlightCompany extends FlightCompanyInput {

	@Id
	private ObjectId _id;

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

}

package com.flightApplication.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Flight extends FlightInput {

	@Id
	private ObjectId _id;

	private int soldTicketCount = 0;
	private BigDecimal currentPrice;
	private Date createDate;
	private Date updateDate;

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public int getSoldTicketCount() {
		return soldTicketCount;
	}

	public void setSoldTicketCount(int soldTicketCount) {
		this.soldTicketCount = soldTicketCount;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}

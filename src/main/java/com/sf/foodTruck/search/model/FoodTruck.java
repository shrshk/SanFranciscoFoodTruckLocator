package com.sf.foodTruck.search.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodTruck {
	// TO DO: create all the fields returned by the API
	private final int dayOrder;
	private final String dayOfWeekStr;
	private final String startTime;
	private final String endtime;
	private final String permit;
	private final String location;
	private final String locationDesc;
	private final String optionalText;
	private final String locationId;
	private final String start24;
	private final String end24;
	private final String cnn;
	private final String addrDateCreate;
	private final String addrDateModified;
	private final String block;
	private final String lot;
	private final String coldTruck;
	private final String Applicant;
	private final String latitude;
	private final String longitude;
	
	@JsonCreator
	public FoodTruck(@JsonProperty("dayorder") int dayOrder, @JsonProperty("dayofweekstr") String dayOfWeekStr,
			@JsonProperty("starttime") String startTime, @JsonProperty("endtime") String endtime,
			@JsonProperty("permit") String permit, @JsonProperty("location") String location,
			@JsonProperty("locationdesc") String locationDesc, @JsonProperty("optionaltext") String optionalText,
			@JsonProperty("locationid") String locationId, @JsonProperty("start24") String start24,
			@JsonProperty("end24") String end24, @JsonProperty("cnn") String cnn,
			@JsonProperty("addrdatecreate") String addrDateCreate,
			@JsonProperty("addrdatemodified") String addrDateModified, @JsonProperty("block") String block,
			@JsonProperty("lot") String lot, @JsonProperty("coldtruck") String coldTruck,
			@JsonProperty("applicant") String applicant, @JsonProperty("latitude") String latitude,
			@JsonProperty("longitude") String longitude) {
		this.dayOrder = dayOrder;
		this.dayOfWeekStr = dayOfWeekStr;
		this.startTime = startTime;
		this.endtime = endtime;
		this.permit = permit;
		this.location = location;
		this.locationDesc = locationDesc;
		this.optionalText = optionalText;
		this.locationId = locationId;
		this.start24 = start24;
		this.end24 = end24;
		this.cnn = cnn;
		this.addrDateCreate = addrDateCreate;
		this.addrDateModified = addrDateModified;
		this.block = block;
		this.lot = lot;
		this.coldTruck = coldTruck;
		Applicant = applicant;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getDayOrder() {
		return dayOrder;
	}

	public String getDayofweekStr() {
		return dayOfWeekStr;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndtime() {
		return endtime;
	}

	public String getPermit() {
		return permit;
	}

	public String getLocation() {
		return location;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public String getOptionalText() {
		return optionalText;
	}

	public String getLocationId() {
		return locationId;
	}

	public String getStart24() {
		return start24;
	}

	public String getEnd24() {
		return end24;
	}

	public String getCnn() {
		return cnn;
	}

	public String getAddrDateCreate() {
		return addrDateCreate;
	}

	public String getAddrDateModified() {
		return addrDateModified;
	}

	public String getBlock() {
		return block;
	}

	public String getLot() {
		return lot;
	}

	public String getColdTruck() {
		return coldTruck;
	}

	public String getApplicant() {
		return Applicant;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "FoodTruck [dayOrder=" + dayOrder + ", dayOfWeekStr=" + dayOfWeekStr + ", startTime=" + startTime
				+ ", endtime=" + endtime + ", permit=" + permit + ", location=" + location + ", locationDesc="
				+ locationDesc + ", optionalText=" + optionalText + ", locationId=" + locationId + ", start24="
				+ start24 + ", end24=" + end24 + ", cnn=" + cnn + ", addrDateCreate=" + addrDateCreate
				+ ", addrDateModified=" + addrDateModified + ", block=" + block + ", lot=" + lot + ", coldTruck="
				+ coldTruck + ", Applicant=" + Applicant + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}

package com.sf.foodTruck.search.service;

public class FoodTruckSearchRequest {
	private final int start;
	private final int limit;

	public FoodTruckSearchRequest(int start, int limit) {
		this.start = start;
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public int getLimit() {
		return limit;
	}

	@Override
	public String toString() {
		return "FoodTruckSearchRequest [start=" + start + ", limit=" + limit + "]";
	}

}

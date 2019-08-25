package com.sf.foodTruck.search.service;

import java.util.List;

import com.sf.foodTruck.search.model.FoodTruck;

public class FoodTruckSearchResult {
	private final int total;
	private final List<FoodTruck> foodTrucks;

	public FoodTruckSearchResult(int total, List<FoodTruck> foodTrucks) {
		this.total = total;
		this.foodTrucks = foodTrucks;
	}

	public int getTotal() {
		return total;
	}

	public List<FoodTruck> getFoodTrucks() {
		return foodTrucks;
	}

	@Override
	public String toString() {
		return "FoodTruckSearchResult [total=" + total + ", foodTrucks=" + foodTrucks + "]";
	}

}

package com.sf.foodTruck.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sf.foodTruck.resource.FoodTruckFinder;

@Component
public class AppRunner implements CommandLineRunner {

	private final FoodTruckFinder foodTruckFinder;

	@Autowired
	public AppRunner(FoodTruckFinder foodTruckFinder) {
		this.foodTruckFinder = foodTruckFinder;
	}

	@Override
	public void run(String... args) {
		foodTruckFinder.findFoodTrucks(0, 10); // Start the Application with
												// pageSize 10.
	}
}

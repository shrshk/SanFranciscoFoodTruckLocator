package com.sf.foodTruck.resource;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.foodTruck.search.model.FoodTruck;
import com.sf.foodTruck.search.service.FoodTruckSearchRequest;
import com.sf.foodTruck.search.service.FoodTruckSearchResult;
import com.sf.foodTruck.search.service.FoodTruckSearchService;

// make this a component which takes in start limit calls a service impl class which 
// hits the API and returns results.
// builds a request using args passed.
@Component
public class FoodTruckFinder {
	private final FoodTruckSearchService foodTruckSearchService;
	
 
	@Autowired
	public FoodTruckFinder(FoodTruckSearchService foodTruckSearchService) {
		this.foodTruckSearchService = foodTruckSearchService;
	}

	// builds a FoodTruckSearchRequest to query open trucks, throttle calls based on input and total results. 
	public void findFoodTrucks(int start, int limit) {
		Scanner keyboard = new Scanner(System.in);
		boolean exit = false;
		do {
			FoodTruckSearchResult foodTruckSearchResult = foodTruckSearchService
					.findOpenFoodTrucks(new FoodTruckSearchRequest(start, limit));
			int total = foodTruckSearchResult.getTotal();
			printResults(foodTruckSearchResult);
			if (start + limit > total) {
				System.out.println("Finished printing the results");
				exit = true;
				keyboard.close();
				return;
			}
			System.out.println("Enter n (quit to exit):");
			String input = keyboard.nextLine();
			if (input != null) {
				if ("quit".equals(input)) {
					System.out.println("Exit programm");
					exit = true;
				} else if ("n".equals(input)) {
					start = start + limit;
					if (start > total)
						exit = true;
				}
			}
		} while (!exit);

		keyboard.close();

	}

	private static void printResults(FoodTruckSearchResult foodTruckSearchResult) {
		if (foodTruckSearchResult.getTotal() == 0)
			System.out.println("No Food Trucks are open at this time");
		for (FoodTruck foodTruck : foodTruckSearchResult.getFoodTrucks()) {
			System.out.println(
					"NAME:" + " " + foodTruck.getApplicant() + " | " + "ADDRESS:" + " " + foodTruck.getLocation() + " | " + foodTruck.getStartTime() + " | " + foodTruck.getEndtime());
		}
	}
}
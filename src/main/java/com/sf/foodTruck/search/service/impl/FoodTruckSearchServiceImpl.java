package com.sf.foodTruck.search.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.foodTruck.external.socrata.data.API.SocrataDataAPI;
import com.sf.foodTruck.search.model.FoodTruck;
import com.sf.foodTruck.search.service.FoodTruckSearchRequest;
import com.sf.foodTruck.search.service.FoodTruckSearchResult;
import com.sf.foodTruck.search.service.FoodTruckSearchService;

// stream foodTrucks, filter collect trucks open now, sort alphabetically and paginate.
@Component
public class FoodTruckSearchServiceImpl implements FoodTruckSearchService {
	private final SocrataDataAPI socrataDataAPI;

	@Autowired
	public FoodTruckSearchServiceImpl(SocrataDataAPI socrataDataAPI) {
		this.socrataDataAPI = socrataDataAPI;
	}

	public FoodTruckSearchResult findOpenFoodTrucks(FoodTruckSearchRequest foodTruckSearchRequest) {
		int start = foodTruckSearchRequest.getStart();
		int limit = foodTruckSearchRequest.getLimit();
		List<FoodTruck> foodTrucks = socrataDataAPI.getFoodTruckList(); // Cache this response: TO DO
		List<FoodTruck> openFoodTrucks = foodTrucks.stream().filter(foodTruck -> isOpen(foodTruck))
				.sorted((truck1, truck2) -> truck1.getApplicant().compareTo(truck2.getApplicant()))
				.collect(Collectors.toList());
		int total = openFoodTrucks.size();
		int toIndex = (start + limit) > total ? total : (start + limit);
		List<FoodTruck> openFoodTrucksSubList = openFoodTrucks.subList(start, toIndex);
		return new FoodTruckSearchResult(total, openFoodTrucksSubList);
	}

	private static boolean isOpen(FoodTruck foodTruck) {
		LocalDateTime now = LocalDateTime.now();
		LocalTime currentTime = now.toLocalTime();
		int currentDayOrder = now.getDayOfWeek().getValue();
		LocalTime begin = null;
		LocalTime end = null;
		try {
			begin = LocalTime.parse(foodTruck.getStart24(), DateTimeFormatter.ofPattern("HH:mm"));
			end = LocalTime.parse(foodTruck.getEnd24(), DateTimeFormatter.ofPattern("HH:mm"));
		} catch (DateTimeParseException ex) {
			System.out.println("Invalid Date String Entered: " + ex);
		}

		int dayOfOrder = foodTruck.getDayOrder();

		return currentDayOrder == dayOfOrder && isBetween(currentTime, begin, end);
	}

	private static boolean isBetween(LocalTime candidate, LocalTime start, LocalTime end) {
		return !candidate.isBefore(start) && !candidate.isAfter(end); // Inclusive.
	}

}

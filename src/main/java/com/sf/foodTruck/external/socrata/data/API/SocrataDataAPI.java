package com.sf.foodTruck.external.socrata.data.API;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sf.foodTruck.search.model.FoodTruck;

// makes an API call and returns the response, (List<FoodTruck).
@Component
public class SocrataDataAPI {
	private final String SocrataDataAPIUrl = "https://data.sfgov.org/resource/jjew-r69b.json";
	// private FoodTruckFileHandler fileHandler;
	private static List<FoodTruck> foodTruckList;
	
	
	public List<FoodTruck> getFoodTruckList() {
		// List<FoodTruck> foodTrucks = null;
		HttpEntity<String> httpRequest = new HttpEntity<>("");
		try {
			RestTemplate restTemplate = new RestTemplate();
			// read from a file 
			// if (read) 
			// fileHandler.write(
	        // else 
			if (foodTruckList==null) {
				foodTruckList = Arrays.asList(restTemplate.exchange(SocrataDataAPIUrl, HttpMethod.GET, httpRequest, FoodTruck[].class)
	                    .getBody());				
			}
			// return from the file.
        } catch (Exception ex) {
           System.out.println("Exception in SocrataDataAPI " + ex);
        }
		return foodTruckList;
	}
}

package com.sf.foodTruck.App;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sf.foodTruck"})
public class SanFranFoodTruckApplication {

	private static Logger LOG = LoggerFactory.getLogger(SanFranFoodTruckApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication app = new SpringApplication(SanFranFoodTruckApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		LOG.info("APPLICATION FINISHED");
	}

}

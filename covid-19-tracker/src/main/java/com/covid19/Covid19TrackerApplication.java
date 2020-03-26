package com.covid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19TrackerApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(Covid19TrackerApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

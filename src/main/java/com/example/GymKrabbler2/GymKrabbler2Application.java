package com.example.GymKrabbler2;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.GymKrabbler2.model.ReadJSONGyms;
import com.example.GymKrabbler2.model.ReadJSONScrapeData;
import com.example.GymKrabbler2.repository.GymRepository;
import com.example.GymKrabbler2.repository.ScrapeDataRepository;

@SpringBootApplication
public class GymKrabbler2Application implements CommandLineRunner {
	@Autowired
	GymRepository gymRepository;
	@Autowired
	ScrapeDataRepository scrapeDataRepository;

	public static void main(String[] args) {
		
	
		SpringApplication.run(GymKrabbler2Application.class, args);

	}
	
	//liest die Daten aus der gymData.json Datei
	@Override
	public void run(String... args) {
		
		
		ReadJSONGyms.parseGyms(gymRepository);
		ReadJSONScrapeData.parseGyms(scrapeDataRepository);
		

	}
}

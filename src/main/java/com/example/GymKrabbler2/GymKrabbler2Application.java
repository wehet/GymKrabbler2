package com.example.GymKrabbler2;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.GymKrabbler2.model.ReadJSON;
import com.example.GymKrabbler2.repository.GymRepository;

@SpringBootApplication
public class GymKrabbler2Application implements CommandLineRunner {
	@Autowired
	GymRepository gymRepository;

	public static void main(String[] args) {
		
	
		SpringApplication.run(GymKrabbler2Application.class, args);

	}
	
	//liest die Daten aus der gymData.json Datei
	@Override
	public void run(String... args) {
		
		
		ReadJSON.parseGyms(gymRepository);
		

	}
}

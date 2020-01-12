package com.flightApplication.demo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.demo.model.Airport;
import com.flightApplication.demo.model.AirportInput;
import com.flightApplication.demo.repository.AirportRepository;

@RestController
@RequestMapping("/api/Airport")
public class AirportController {

	@Autowired
	private AirportRepository airportRepository;

	@PostMapping("/addAirport")
	public Airport addAirport(@RequestBody AirportInput airport) {
		Airport newAirport = new Airport();
		newAirport.setAirportName(airport.getAirportName());
		newAirport.setAirportCity(airport.getAirportCity());
		newAirport.set_id(ObjectId.get());
		return airportRepository.save(newAirport);
	}

	// TODO city name e göre arama ekle ve kriterleri düzenle
	@GetMapping("/searchAirport")
	public List<Airport> searchAirport(@RequestParam(required = false) String airportName,
			@RequestParam(required = false) String airportCity) {
		if ((airportName == null || airportName.isEmpty()) && (airportCity == null || airportCity.isEmpty())) {
			return airportRepository.findAll();
		} else {
			return airportRepository.findAirportByNameAndCity(airportName, airportCity);
		}
	}

}

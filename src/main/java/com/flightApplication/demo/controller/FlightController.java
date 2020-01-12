package com.flightApplication.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.demo.model.Flight;
import com.flightApplication.demo.model.FlightInput;
import com.flightApplication.demo.model.Route;
import com.flightApplication.demo.repository.FlightRepository;
import com.flightApplication.demo.repository.RouteRepository;

@RestController
@RequestMapping("/api/Flight")
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private RouteRepository routeRepository;

	@PostMapping("/addFlight")
	public Flight addRoute(@RequestBody FlightInput flight) {
		Flight newFlight = new Flight();
		newFlight.setCapacity(flight.getCapacity());
		newFlight.setDepartureDate(flight.getDepartureDate());
		newFlight.setRouteId(flight.getRouteId());
		Optional<Route> route = routeRepository.findById(flight.getRouteId());
		newFlight.setCurrentPrice(route.get().getDefaultPrice());
		newFlight.setCreateDate(new Date(System.currentTimeMillis()));
		newFlight.set_id(ObjectId.get());
		return flightRepository.save(newFlight);
	}

	// TODO
	@GetMapping("/searchFlight/")
	public List<Flight> searchRoute() {
		return flightRepository.findAll();

	}

}

package com.flightApplication.demo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.demo.model.Route;
import com.flightApplication.demo.model.RouteInput;
import com.flightApplication.demo.repository.RouteRepository;

@RestController
@RequestMapping("/api/Route")
public class RouteController {

	@Autowired
	private RouteRepository routeRepository;

	@PostMapping("/addRoute")
	public Route addRoute(@RequestBody RouteInput route) {
		Route newRoute = new Route();
		newRoute.setAirportIdFrom(route.getAirportIdFrom());
		newRoute.setAirportIdTo(route.getAirportIdTo());
		newRoute.setDefaultPrice(route.getDefaultPrice());
		newRoute.setFlightcompanyId(route.getFlightcompanyId());
		newRoute.set_id(ObjectId.get());
		return routeRepository.save(newRoute);
	}

	// TODO
	@GetMapping("/searchRoute/")
	public List<Route> searchRoute() {
		return routeRepository.findAll();
	}

}

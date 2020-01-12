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

import com.flightApplication.demo.model.FlightCompany;
import com.flightApplication.demo.model.FlightCompanyInput;
import com.flightApplication.demo.repository.FlightCompanyRepository;

@RestController
@RequestMapping("/api/FlightCompany")
public class FlightCompanyController {

	@Autowired
	private FlightCompanyRepository flightCompanyrepository;

	@PostMapping("/addFlightCompany")
	public FlightCompany addFlightCompany(@RequestBody FlightCompanyInput company) {
		FlightCompany flightCompany = new FlightCompany();
		flightCompany.setCompanyName(company.getCompanyName());
		flightCompany.set_id(ObjectId.get());
		return flightCompanyrepository.save(flightCompany);
	}

	@GetMapping("/searchFlightCompany")
	public List<FlightCompany> searchFlightCompany(@RequestParam(required = false) String companyName) {
		if (companyName == null || companyName.isEmpty()) {
			return flightCompanyrepository.findAll();
		} else {
			return flightCompanyrepository.findCompanyByName(companyName);
		}
	}

}

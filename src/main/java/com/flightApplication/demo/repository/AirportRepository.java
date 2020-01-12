package com.flightApplication.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightApplication.demo.model.Airport;

@Repository
public interface AirportRepository extends MongoRepository<Airport, Long> {

	@Query(value = "{'airportName' : ?0, 'airportCity' : ?0}")
	List<Airport> findAirportByNameAndCity(String airportName, String airportCity);

}

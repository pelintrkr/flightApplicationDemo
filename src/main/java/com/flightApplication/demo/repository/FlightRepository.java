package com.flightApplication.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightApplication.demo.model.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, Object> {

}

package com.flightApplication.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightApplication.demo.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Object> {

	@Query(value = "{'passengerID' : ?0}")
	List<Ticket> findticketByPassengerId(String passengerId);

}

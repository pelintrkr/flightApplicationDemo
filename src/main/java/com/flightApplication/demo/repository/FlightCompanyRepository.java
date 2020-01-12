package com.flightApplication.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightApplication.demo.model.FlightCompany;

@Repository
public interface FlightCompanyRepository extends MongoRepository<FlightCompany, Object> {

	@Query(value = "{'companyName' : ?0}")
	List<FlightCompany> findCompanyByName(String companyName);

}

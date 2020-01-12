package com.flightApplication.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.flightApplication.demo.model.Route;

@Repository
public interface RouteRepository extends MongoRepository<Route, Object> {

}

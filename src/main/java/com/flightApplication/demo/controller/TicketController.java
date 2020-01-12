package com.flightApplication.demo.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApplication.demo.model.Flight;
import com.flightApplication.demo.model.Ticket;
import com.flightApplication.demo.model.TicketInput;
import com.flightApplication.demo.model.TicketStatusEnum;
import com.flightApplication.demo.repository.FlightRepository;
import com.flightApplication.demo.repository.TicketRepository;

@RestController
@RequestMapping("/api/Ticket")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private FlightRepository flightRepository;

	@PostMapping("/buyTicket")
	public Ticket addRoute(@RequestBody TicketInput ticket) {
		Ticket newticket = new Ticket();
		newticket.setFlightId(ticket.getFlightId());
		newticket.setPassengerID(ticket.getPassengerID());
		newticket.setFlightId(ticket.getFlightId());
		newticket.setCreateTime(new Timestamp(System.currentTimeMillis()));
		newticket.setTicketStatus(TicketStatusEnum.ACTIVE.getValue());
		Optional<Flight> flight = flightRepository.findById(ticket.getFlightId());
		newticket.setPrice(flight.get().getCurrentPrice());
		int availability = flight.get().getCapacity() - flight.get().getSoldTicketCount();
		if (availability != 0) {
			flight.get().setSoldTicketCount(flight.get().getSoldTicketCount() + 1);
			flight.get().setUpdateDate(new Timestamp(System.currentTimeMillis()));
			if ((flight.get().getSoldTicketCount() / flight.get().getCapacity()) % 0.10 >= 0) {
				flight.get().setCurrentPrice(flight.get().getCurrentPrice().multiply(new BigDecimal(1.10)));
			}
			flightRepository.save(flight.get());
		}

		return ticketRepository.save(newticket);
	}

	@GetMapping("/cancelTicket/{ticketId}")
	public void cancelTicket(@PathVariable("ticketId") final String ticketId) throws Exception {
		Optional<Ticket> ticket = ticketRepository.findById(ticketId);
		if (ticket != null && ticket.get() != null) {
			if (TicketStatusEnum.ACTIVE.getValue().equals(ticket.get().getTicketStatus())) {
				ticket.get().setTicketStatus(TicketStatusEnum.CANCELLED.getValue());
				ticketRepository.save(ticket.get());
				Optional<Flight> flight = flightRepository.findById(ticket.get().getFlightId());
				flight.get().setSoldTicketCount(flight.get().getSoldTicketCount() + 1);
				flight.get().setUpdateDate(new Timestamp(System.currentTimeMillis()));
				if ((flight.get().getSoldTicketCount() / flight.get().getCapacity()) % 0.10 == 0) {
					flight.get().setCurrentPrice(flight.get().getCurrentPrice().multiply(new BigDecimal(0.90)));
				}
				flightRepository.save(flight.get());
			} else {
				throw new Exception("Ticket is already cancelled!");
			}
		} else {
			throw new Exception("Ticket not found!");
		}
	}

	@GetMapping("/searchTicket/{passengerId}")
	public List<Ticket> searchRoute(@PathVariable("passengerId") final String passengerId) {
		return ticketRepository.findticketByPassengerId(passengerId);
	}

}

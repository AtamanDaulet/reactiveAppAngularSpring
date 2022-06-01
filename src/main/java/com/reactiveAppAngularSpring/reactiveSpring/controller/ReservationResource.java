package com.reactiveAppAngularSpring.reactiveSpring.controller;

import com.reactiveAppAngularSpring.reactiveSpring.model.Reservation;
import com.reactiveAppAngularSpring.reactiveSpring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin //angular and spring can work locally. potential security issue
public class ReservationResource {
	public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";
	private final ReservationService reservationService;
	@Autowired
	public ReservationResource(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping(path = {"{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Reservation> getReservationById(@PathVariable String id){
		return reservationService.getReservation(id);
	}

	@PostMapping(path = {""}, produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){
		return reservationService.createReservation(reservation);
	}

	@PutMapping(path = {"{id}"}, produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Reservation> updatePrice(@PathVariable String id, @RequestBody Mono<Reservation> reservation){
		return reservationService.updateReservation(id, reservation);
	}

	@DeleteMapping(path = {"{id}"})
	public Mono<Boolean> deleteReservation(@PathVariable String id){
		return reservationService.deleteReservation(id);
	}
}

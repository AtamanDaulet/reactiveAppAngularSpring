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

	@PutMapping(path = {"{roomId}"}, produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> updatePrice(@PathVariable String roomId, @RequestBody Mono<Reservation> reservation){

		//reservationService.getReservation(roomId)

		return Mono.just("{updatePrice}");
	}

	@DeleteMapping(path = {"{roomId}"})
	public Mono<Boolean> deleteReservation(@PathVariable String roomId){

		//reservationService.getReservation(roomId)

		return Mono.just(true);
	}
}

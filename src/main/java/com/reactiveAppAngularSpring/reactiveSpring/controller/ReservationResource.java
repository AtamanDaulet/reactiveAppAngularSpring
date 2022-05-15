package com.reactiveAppAngularSpring.reactiveSpring.controller;

import com.reactiveAppAngularSpring.reactiveSpring.model.Reservation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin //angular and spring can work locally. potential security issue
public class ReservationResource {
	public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";

	@GetMapping(path = {"{roomId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> getReservationById(@PathVariable String roomId){

		//reservationService.getReservation(roomId)

		return Mono.just("{}");
	}

	@PostMapping(path = {""}, produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> createReservation(@RequestBody Mono<Reservation> reservation){

		//reservationService.getReservation(roomId)

		return Mono.just("{createReservation}");
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

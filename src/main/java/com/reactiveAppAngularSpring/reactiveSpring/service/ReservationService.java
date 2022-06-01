package com.reactiveAppAngularSpring.reactiveSpring.service;

import com.reactiveAppAngularSpring.reactiveSpring.model.Reservation;
import reactor.core.publisher.Mono;

public interface ReservationService {

	Mono<Reservation> getReservation(String id);
	Mono<Reservation> createReservation(Mono<Reservation> reservationMono);
	Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono);
	Mono<Boolean> deleteReservation(String id);
}

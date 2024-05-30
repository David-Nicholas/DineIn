package com.ic.dinin.controllers;

import com.ic.dinin.domain.Reservation;
import com.ic.dinin.dto.ReservationDTO;
import com.ic.dinin.dto.ReservationInputDTO;
import com.ic.dinin.services.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ReservationController {
    private final ModelMapper modelMapper;
    private final ReservationService reservationService;

    public ReservationController(ModelMapper modelMapper, ReservationService reservationService) {
        this.modelMapper = modelMapper;
        this.reservationService = reservationService;
    }

    @PostMapping("/reservations")
    public ResponseEntity<Object> createReservation(@RequestBody ReservationInputDTO reservation) {
        float reservationDuration = reservation.getReservationDuration();
        LocalDateTime startReservationTime = reservation.getStartReservationTime();
        long restaurantId = reservation.getRestaurantId();
        int numberOfPeople = reservation.getNumberOfPeople();
        String phoneNumber = reservation.getPhoneNumber();

        Reservation createdReservation = reservationService.createReservation(reservationDuration, startReservationTime, restaurantId, numberOfPeople, phoneNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(createdReservation, ReservationDTO.class));
    }
}
